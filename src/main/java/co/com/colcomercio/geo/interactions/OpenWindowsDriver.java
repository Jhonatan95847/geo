package co.com.colcomercio.geo.interactions;


import co.com.colcomercio.geo.utils.WinAppDriver;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class OpenWindowsDriver implements Interaction {

    private String appUrl;

    public OpenWindowsDriver(String appUrl) {
        this.appUrl = appUrl;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        AppiumDriver driver = new WinAppDriver(appUrl).connect();
        Serenity.setSessionVariable("urlApp").to(appUrl);
        actor.whoCan(BrowseTheWeb.with(driver));
    }
    public static OpenWindowsDriver openTheApp(String appUrl){
        return Tasks.instrumented(OpenWindowsDriver.class, appUrl);
    }
}
