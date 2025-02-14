package co.com.colcomercio.geo.interactions;


import co.com.colcomercio.geo.models.vnc.Vnc;
import co.com.colcomercio.geo.tasks.LoginGeo;
import co.com.colcomercio.geo.userinterfaces.GeoPosWindow;
import co.com.colcomercio.geo.utils.GetDataModel;
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

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class GoToStart implements Task {

    public static GoToStart go() {
        return Tasks.instrumented(GoToStart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Vnc dataVnc;
        dataVnc = GetDataModel.vnc("caja_185");
        try {
            // Captura de pantalla
            File screenshot = ScreenCapture.captureWindow(dataVnc.getDataVnc().getNameWindow(),"screenshot.png");

            // Procesamiento con OCR
            String extractedText = OCRProcessor.extractTextFromImage(screenshot);

            actor.attemptsTo(
                    PerformWait.wait(LOW_TIME)
            );
            // Validación
            if (extractedText.contains("Ingrese el nro")||extractedText.contains("Cliente Registrado")||extractedText.contains("Cliente con")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
                );
            } else if (extractedText.contains("Seleccione un Convenio")||extractedText.contains("Desea realizar una donacion")||extractedText.contains("Ingrese el monto")||extractedText.contains("Error")||extractedText.contains("Forma de Pago")||extractedText.contains("Ingrese el articulo")){
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("nde")||extractedText.contains("seso")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_S),
                        PerformWait.wait(LOW_TIME)
                );
            } else if (extractedText.contains("Asignado")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_S)
                );
            } else if (extractedText.contains("Confirma la venta")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_S),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
                );
            } else if (extractedText.contains("Datos del cliente")) {
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
                );
            } else{
                actor.attemptsTo(
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_F11),
                        PerformWait.wait(LOW_TIME),
                        PresionarTecla.conCodigo(KeyEvent.VK_S),
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