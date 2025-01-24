package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.SwitchWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.geo.userinterfaces.VncWindow.*;

public class LoginOnVnc implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("10.181.5.176").into(EDIT_BAR),
                Click.on(AUTOSCALE),
                Click.on(CONECT),
                SwitchWindow.switchTheWindow("Root","VNC Authentication   "+"10.181.5.176"+":5900"),
                Click.on(PASSWORD),
                Enter.theValue("123456").into(PASSWORD).thenHit(Keys.ENTER));
    }
    public static LoginOnVnc loginOnVnc(){
        return Tasks.instrumented(LoginOnVnc.class);
    }
}
