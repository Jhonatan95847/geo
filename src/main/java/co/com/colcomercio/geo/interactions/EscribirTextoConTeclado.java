package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirTextoConTeclado implements Task {

    private final String texto;

    public EscribirTextoConTeclado(String texto) {
        this.texto = texto;
    }

    public static EscribirTextoConTeclado elTexto(String texto) {
        return instrumented(EscribirTextoConTeclado.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Robot robot = new Robot();
            for (char c : texto.toCharArray()) {
                enviarTecla(robot, c);
            }
        } catch (AWTException e) {
            throw new RuntimeException("Error al inicializar Robot para enviar texto: " + texto, e);
        }
    }

    private void enviarTecla(Robot robot, char c) {
        if (Character.isUpperCase(c)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }

        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);

        if (Character.isUpperCase(c)) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }

        robot.delay(100); // Pequeña pausa entre teclas
    }
}
