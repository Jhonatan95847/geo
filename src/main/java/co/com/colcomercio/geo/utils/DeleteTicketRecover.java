package co.com.colcomercio.geo.utils;

import com.jcraft.jsch.*;

import java.util.List;


public class DeleteTicketRecover {

    private DeleteTicketRecover() {
        throw new IllegalStateException("Utility class");
    }
    public static String deleteTheFolderSesions() {

        String host = "10.181.5.119";
        int port = 22;
        String username = "user77";
        String password = "geocom";
        String remotePath = "//geopos2//";
        String remoteFolderPath = "//ticketRecover";

        String latestFolder = null;
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            List<ChannelSftp.LsEntry> entries = sftpChannel.ls(remotePath);

            long lastTimestamp = 0;

            for (ChannelSftp.LsEntry entry : entries) {
                if (entry.getFilename().startsWith("geopos2-alkosto-") && entry.getAttrs().isDir()) {
                    long timestammp = entry.getAttrs().getMTime();
                    if (timestammp > lastTimestamp) {
                        lastTimestamp = timestammp;
                        latestFolder = entry.getFilename();
                    }
                }
            }
            if (isDirectoryExists(sftpChannel, remotePath+latestFolder+remoteFolderPath)) {
                deleteFolder(sftpChannel,remotePath+latestFolder+remoteFolderPath);
            }


            sftpChannel.disconnect();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }
        return remotePath+latestFolder+remoteFolderPath;
    }
    private static boolean isDirectoryExists(ChannelSftp sftpChannel, String folderPath) {
        try {
            sftpChannel.cd(folderPath);
            return true;
        } catch (SftpException e) {
            return false;
        }
    }
    private static void deleteFolder(ChannelSftp sftpChannel, String folderPath) throws SftpException {
        @SuppressWarnings("unchecked")
        List<ChannelSftp.LsEntry> list = sftpChannel.ls(folderPath);

        for (ChannelSftp.LsEntry entry : list) {
            String entryName = entry.getFilename();
            if (!entryName.equals(".") && !entryName.equals("..")) {
                String entryPath = folderPath + "/" + entryName;

                if (entry.getAttrs().isDir()) {

                    deleteFolder(sftpChannel, entryPath);
                } else {
                    sftpChannel.rm(entryPath);
                }
            }
        }

        sftpChannel.rmdir(folderPath);
    }
}
