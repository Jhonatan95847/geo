package co.com.colcomercio.geo.tasks;



import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Vector;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Subject("Descargar el último archivo desde SFTP")
public class DownloadFileViaSFTP implements Task {
    private static final Logger logger = LogManager.getLogger(DownloadFileViaSFTP.class);
    private final String sftpHost;
    private final int sftpPort;
    private final String sftpUser;
    private final String sftpPassword;
    private final String remoteFolderPath;
    private final String localFolderPath;

    public DownloadFileViaSFTP(String sftpHost, int sftpPort, String sftpUser, String sftpPassword, String remoteFolderPath, String localFolderPath) {
        logger.info("Descargando archivo");
        this.sftpHost = sftpHost;
        this.sftpPort = sftpPort;
        this.sftpUser = sftpUser;
        this.sftpPassword = sftpPassword;
        this.remoteFolderPath = remoteFolderPath;
        this.localFolderPath = localFolderPath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(sftpUser, sftpHost, sftpPort);
            session.setPassword(sftpPassword);

            // Configurar las propiedades de la sesión
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // Conectar la sesión
            session.connect();

            // Abrir el canal SFTP
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            // Listar los archivos en el directorio remoto
            Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteFolderPath);
            if (files.isEmpty()) {
                throw new RuntimeException("No se encontraron archivos en el directorio remoto: " + remoteFolderPath);
            }

            // Encontrar el archivo más reciente
            ChannelSftp.LsEntry latestFile = files.stream()
                    .filter(file -> !file.getAttrs().isDir()) // Ignorar directorios
                    .max((file1, file2) -> Long.compare(
                            file1.getAttrs().getMTime(),
                            file2.getAttrs().getMTime()
                    ))
                    .orElseThrow(() -> new RuntimeException("No se encontró ningún archivo en el directorio remoto"));

            String latestFileName = latestFile.getFilename();
            String remoteFilePath = remoteFolderPath + "/" + latestFileName;
            String localFilePath = localFolderPath + "/" + latestFileName;

            System.out.println("ultimo archivo encontrado: " + latestFileName);

            // Descargar el archivo más reciente
            InputStream inputStream = channelSftp.get(remoteFilePath);
            try (FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("Archivo descargado exitosamente: " + localFilePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al descargar el ultimo archivo por SFTP", e);
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }

    // Método estático para crear la tarea
    public static DownloadFileViaSFTP from(String sftpHost, int sftpPort, String sftpUser, String sftpPassword, String remoteFolderPath, String localFolderPath) {
        return instrumented(DownloadFileViaSFTP.class, sftpHost, sftpPort, sftpUser, sftpPassword, remoteFolderPath, localFolderPath);
    }
}
