package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class PayRedeban implements Interaction {

    private final String tarjeta;
    private final String franquicia;

    public PayRedeban(String tarjeta, String franquicia) {
        this.tarjeta = tarjeta;
        this.franquicia = franquicia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(LOW_TIME),
                EscribirTextoConTeclado.elTexto("1234"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER), //bin
                SelectCard.select(tarjeta),
                SelectFranquicia.select(franquicia)
        );
    }

    public static PayRedeban pay(String tarjeta, String franquicia){
        return Tasks.instrumented(PayRedeban.class, tarjeta, franquicia);
    }
}
