package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.utils.RunWinAppDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.com.colcomercio.geo.utils.WinAppDriver.theApplication;
import static co.com.colcomercio.geo.utils.WinAppDriver.theApplication;

public class SwitchWindow implements Interaction {

    private String winName;
    private String nameWindow;

    public SwitchWindow(String winName, String nameWindow) {
        this.winName = winName;
        this.nameWindow = nameWindow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.can(RunWinAppDriver.with(theApplication(winName).switchWindow(nameWindow)));
    }
    public static SwitchWindow switchTheWindow(String winName,String nameWindow){
        return Tasks.instrumented(SwitchWindow.class,winName,nameWindow);
    }
}
