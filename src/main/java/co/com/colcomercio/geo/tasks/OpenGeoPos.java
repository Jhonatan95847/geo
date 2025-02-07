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

import java.awt.event.KeyEvent;


public class OpenGeoPos implements Task {


    public OpenGeoPos(){

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        GeoPosWindow.updateLocalPos();
        actor.attemptsTo(
                //WaitUntil.the(GeoPosWindow.LOCAL_POS, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                PerformWait.wait(3)
        );
    }
    public static OpenGeoPos open(){
        return Tasks.instrumented(OpenGeoPos.class);
    }
}
