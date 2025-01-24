package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.exceptions.TimeConditionException;
import co.com.colcomercio.geo.interactions.CaptureScreen;
import co.com.colcomercio.geo.utils.ScreenCapture;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.Arrays;
import java.util.List;

public class WaitLoad implements Interaction {
    private final List<String> texts;
    private final String nameImageOne;
    private final String nameImageTwo;

    public WaitLoad(String text, String nameImageOne, String nameImageTwo) {
        this.texts = Arrays.asList(text.split(","));
        this.nameImageOne = nameImageOne;
        this.nameImageTwo = nameImageTwo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long timeInit = System.currentTimeMillis();
        long timeLimit = timeInit + 360000;

        actor.attemptsTo(CaptureScreen.captureScreen(nameImageOne));



        actor.attemptsTo(CaptureScreen.captureScreen(nameImageTwo));
    }

    public static WaitLoad load(String text, String nameImageOne, String nameImageTwo) {
        return Tasks.instrumented(WaitLoad.class, text, nameImageOne, nameImageTwo);
    }
}