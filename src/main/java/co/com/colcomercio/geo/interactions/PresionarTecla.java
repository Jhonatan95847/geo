package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PresionarTecla implements Task {

    private final int tecla;

    public PresionarTecla(int tecla) {
        this.tecla = tecla;
    }

    public static PresionarTecla conCodigo(int tecla) {
        return instrumented(PresionarTecla.class, tecla);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Robot robot = new Robot();
            robot.keyPress(tecla); // Presiona la tecla
            robot.keyRelease(tecla); // Suelta la tecla
            robot.delay(100); // Pequeña pausa para evitar problemas
        } catch (AWTException e) {
            throw new RuntimeException("Error al inicializar Robot para presionar la tecla: " + tecla, e);
        }
    }
}