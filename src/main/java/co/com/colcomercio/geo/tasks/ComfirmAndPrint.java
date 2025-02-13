package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.interactions.PresionarTecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class ComfirmAndPrint implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidateTextOnScreen.contains("firma"),
                PresionarTecla.conCodigo(KeyEvent.VK_S),
                PerformWait.wait(3),
                PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                PerformWait.wait(12),
                ValidateTextOnScreen.contains("Impresora"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME)
        );
    }
    public static ComfirmAndPrint confirm(){
        return Tasks.instrumented(ComfirmAndPrint.class);
    }
}
