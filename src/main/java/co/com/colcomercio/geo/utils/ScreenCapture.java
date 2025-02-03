package co.com.colcomercio.geo.utils;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenCapture {

    /**
     * Captura solo la ventana de la aplicación especificada y guarda la imagen.
     *
     * @param windowTitle El título exacto de la ventana a capturar.
     * @param filePath    Ruta donde se guardará la imagen (incluyendo el nombre del archivo).
     * @return Archivo con la captura de pantalla de la ventana.
     * @throws IOException  Si hay un error al guardar la imagen.
     * @throws AWTException Si hay un error al capturar la pantalla.
     */
    public static File captureWindow(String windowTitle, String filePath) throws IOException, AWTException {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, windowTitle);

        if (hwnd == null) {
            throw new RuntimeException("No se encontró la ventana con título: " + windowTitle);
        }

        // Obtener el tamaño y posición de la ventana
        WinDef.RECT rect = new WinDef.RECT();
        User32.INSTANCE.GetWindowRect(hwnd, rect);
        Rectangle windowRect = new Rectangle(rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);

        // Capturar la imagen de la ventana
        Robot robot = new Robot();
        BufferedImage windowImage = robot.createScreenCapture(windowRect);

        // (Opcional) Mejorar la imagen para OCR
        BufferedImage processedImage = preprocessImageForOCR(windowImage);

        // Guardar la imagen
        File outputFile = new File(filePath);
        ImageIO.write(processedImage, "png", outputFile);

        return outputFile;
    }

    /**
     * Preprocesa la imagen para mejorar la lectura con OCR.
     *
     * @param image Imagen original capturada.
     * @return Imagen preprocesada en blanco y negro.
     */
    private static BufferedImage preprocessImageForOCR(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D g2d = grayImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return grayImage;
    }


    public static void main(String[] args) {
        try {
            String windowTitle = "Bloc de notas"; // Cambiar por el título de la ventana en pruebas
            String filePath = "screenshot.png";

            File screenshot = captureWindow(windowTitle, filePath);
            System.out.println("Captura guardada en: " + screenshot.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

