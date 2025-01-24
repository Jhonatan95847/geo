package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.interactions.PresionarTecla;
import co.com.colcomercio.geo.userinterfaces.GeoPosWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.awt.event.KeyEvent;

public class LoginGeo implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EscribirTextoConTeclado.elTexto("user77"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                EscribirTextoConTeclado.elTexto("geocom"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(30)
        );
    }
    public static LoginGeo open(){
        return Tasks.instrumented(LoginGeo.class);
    }
}
