package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.*;
import co.com.colcomercio.geo.interactions.CaptureScreen;
import co.com.colcomercio.geo.userinterfaces.GeoPosWindow;
import co.com.colcomercio.geo.utils.ScreenCapture;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;



public class OpenGeoPos implements Task {


    public OpenGeoPos(){

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        GeoPosWindow.updateLocalPos();
        actor.attemptsTo(
                CleanRegister.deleteTheSessions(),
                SwitchToWindow.withTitle("x0vncserver "),
                WaitUntil.the(GeoPosWindow.LOCAL_POS, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds()
        );

        actor.attemptsTo(
                Click.on(GeoPosWindow.LOCAL_POS),
                Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                Enter.theValue(Keys.DOWN).into(GeoPosWindow.LOCAL_POS),
                Enter.theValue(Keys.ENTER).into(GeoPosWindow.LOCAL_POS),
                PerformWait.wait(60),
                ValidateTextOnScreen.contains("Ingreso de Usuario"),
                WaitLoad.load("Ingreso","Load","Login")

        );

    }
    public static OpenGeoPos open(){
        return Tasks.instrumented(OpenGeoPos.class);
    }
}
