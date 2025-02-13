package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.geo.utils.WaitingTime.MEDIUM_TIME;

public class PayCredibanco implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(MEDIUM_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(MEDIUM_TIME)
        );
    }
    public static PayCredibanco pay(){
        return Tasks.instrumented(PayCredibanco.class);
    }
}


