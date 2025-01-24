package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.utils.ScreenCapture;
import co.com.colcomercio.geo.utils.OCRProcessor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import java.io.File;

public class ValidateTextOnScreen implements Task {
    private final String expectedText;

    public ValidateTextOnScreen(String expectedText) {
        this.expectedText = expectedText;
    }

    public static ValidateTextOnScreen contains(String text) {
        return Tasks.instrumented(ValidateTextOnScreen.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Captura de pantalla
            File screenshot = ScreenCapture.captureScreen("screenshot.png");

            // Procesamiento con OCR
            String extractedText = OCRProcessor.extractTextFromImage(screenshot);

            // Validación
            if (!extractedText.contains(expectedText)) {
                throw new AssertionError("Texto esperado no encontrado: " + expectedText);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error durante la validación de texto en pantalla", e);
        }
    }
}
