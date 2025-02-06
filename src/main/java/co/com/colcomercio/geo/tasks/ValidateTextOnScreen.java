package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.utils.ScreenCapture;
import co.com.colcomercio.geo.utils.OCRProcessor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.File;

public class ValidateTextOnScreen implements Task {
    private final String expectedText;
    private static final int MAX_ATTEMPTS = 3; // Número máximo de intentos
    private static final int WAIT_TIME = 2; // Tiempo de espera en segundos entre intentos

    public ValidateTextOnScreen(String expectedText) {
        this.expectedText = expectedText;
    }

    public static ValidateTextOnScreen contains(String text) {
        return Tasks.instrumented(ValidateTextOnScreen.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int attempt = 0;
        boolean found = false;

        while (attempt < MAX_ATTEMPTS && !found) {
            try {
                // Captura de pantalla
                File screenshot = ScreenCapture.captureWindow("pos@alk33-03qa1 ", "screenshot.png");
                //actor.attemptsTo(PerformWait.wait(WAIT_TIME));

                // Procesamiento con OCR
                String extractedText = OCRProcessor.extractTextFromImage(screenshot);
                actor.attemptsTo(PerformWait.wait(WAIT_TIME));

                // Validación del texto
                if (extractedText.contains(expectedText)) {
                    found = true;
                } else {
                    attempt++;
                    if (attempt < MAX_ATTEMPTS) {
                        System.out.println("Intento " + attempt + " fallido. Reintentando...");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("Error durante la validación de texto en pantalla", e);
            }
        }

        if (!found) {
            throw new AssertionError("Texto esperado no encontrado después de " + MAX_ATTEMPTS + " intentos: " + expectedText);
        }
    }
}
