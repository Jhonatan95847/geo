package co.com.colcomercio.geo.utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class OCRProcessor {
    public static String extractTextFromImage(File imageFile) throws TesseractException {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\1049644474\\Documents\\Tesseract-OCR\\tessdata"); // Ruta a tessdata
        tesseract.setLanguage("spa"); // Idioma
        return tesseract.doOCR(imageFile);
    }
}
