package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.annotations.Subject;

import java.awt.*;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Subject("Cerrar la ventana activa con Alt + F4")
public class CloseWindowWithAltF4 implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Crear una instancia de Robot
            Robot robot = new Robot();

            // Presionar Alt + F4
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);

            // Liberar las teclas
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            throw new RuntimeException("Error al intentar presionar Alt + F4", e);
        }
    }

    // Método estático para usar la interacción
    public static CloseWindowWithAltF4 close() {
        return instrumented(CloseWindowWithAltF4.class);
    }
}
