package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class AddProduct implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidateTextOnScreen.contains("articulo"),
                EscribirTextoConTeclado.elTexto("8806098432516"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                EscribirTextoConTeclado.elTexto("7701023185240"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                EscribirTextoConTeclado.elTexto("7707611662261"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                EscribirTextoConTeclado.elTexto("7705946297516"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(2),
                //ValidateTextOnScreen.contains("Registrados 4"),
                PresionarTecla.conCodigo(KeyEvent.VK_F9),
                PerformWait.wait(LOW_TIME)
        );
    }
    public static AddProduct agregate(){
        return Tasks.instrumented(AddProduct.class);
    }
}
