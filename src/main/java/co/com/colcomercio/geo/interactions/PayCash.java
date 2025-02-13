package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.geo.utils.WaitingTime.MEDIUM_TIME;

public class PayCash implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actot) {
        actot.attemptsTo(
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(MEDIUM_TIME),
                //ValidateTextOnScreen.contains("Ingrese"),
                EscribirTextoConTeclado.elTexto("3000000"),
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME)
        );
    }
    public static PayCash pay(){
        return Tasks.instrumented(PayCash.class);
    }
}
