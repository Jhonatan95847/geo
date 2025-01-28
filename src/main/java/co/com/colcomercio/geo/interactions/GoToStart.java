package co.com.colcomercio.geo.interactions;


import co.com.colcomercio.geo.tasks.LoginGeo;
import co.com.colcomercio.geo.userinterfaces.GeoPosWindow;
import co.com.colcomercio.geo.utils.ScreenCapture;
import co.com.colcomercio.geo.utils.OCRProcessor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.awt.event.KeyEvent;
import java.io.File;

public class GoToStart implements Task {


    public static GoToStart go() {
        return Tasks.instrumented(GoToStart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Captura de pantalla
            File screenshot = ScreenCapture.captureScreen("screenshot.png");

            // Procesamiento con OCR
            String extractedText = OCRProcessor.extractTextFromImage(screenshot);

            actor.attemptsTo(
                    PerformWait.wait(3)
            );
            // Validación
            if (extractedText.contains("Ingrese el nro")||extractedText.contains("Cliente registrado")||extractedText.contains("Cliente con")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
                );
            } else if (extractedText.contains("Seleccione un Convenio")||extractedText.contains("Desea realizar una donacion")||extractedText.contains("Ingrese el monto")){
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("Vendedor")||extractedText.contains("Aseso")||extractedText.contains("Forma de pago")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("Ingrese el articulo")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("Vendedor asignado")||extractedText.contains("Asesor asignado")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("Confirma la venta")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_S),
                        PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
                );
            } else if (extractedText.contains("Datos del cliente")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
                );
            } else{
                actor.attemptsTo(
                        CloseWindowWithAltF4.close(),
                        Click.on(GeoPosWindow.LOCAL_POS),
                        Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                        Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                        Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                        Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                        Enter.theValue(Keys.ENTER).into(GeoPosWindow.LOCAL_POS),
                        PerformWait.wait(35),
                        LoginGeo.open()
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Error durante la validación de texto en pantalla", e);
        }
    }
}