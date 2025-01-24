package co.com.colcomercio.geo.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenCapture {

    /**
     * Captura la pantalla completa y guarda la imagen en un archivo.
     *
     * @param filePath Ruta donde se guardará la imagen (incluyendo el nombre del archivo).
     * @return Archivo que contiene la captura de pantalla.
     * @throws IOException Si ocurre un error al escribir el archivo.
     * @throws AWTException Si ocurre un error al capturar la pantalla.
     */
    public static File captureScreen(String filePath) throws IOException, AWTException {
        // Crear un objeto Robot para capturar la pantalla
        Robot robot = new Robot();

        // Obtener el tamaño de la pantalla
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        // Capturar la pantalla como una imagen
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

        // Crear un archivo para guardar la imagen
        File outputFile = new File(filePath);

        // Guardar la imagen en el archivo
        ImageIO.write(screenFullImage, "png", outputFile);

        // Devolver el archivo generado
        return outputFile;
    }

    public static void main(String[] args) {
        try {
            // Ruta donde se guardará la captura
            String filePath = "screenshot.png";

            // Llamar al método de captura
            File screenshot = captureScreen(filePath);

            // Confirmar éxito
            System.out.println("Captura guardada en: " + screenshot.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

