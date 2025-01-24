package co.com.colcomercio.geo.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


public class SwitchToWindow implements Interaction {

    private String windowTitle;

    public SwitchToWindow(String windowTitle) {
        this.windowTitle = windowTitle;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String currentWindowHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();


        for (String windowHandle :  BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
            BrowseTheWeb.as(actor).getDriver().switchTo().window(windowHandle);
            if (BrowseTheWeb.as(actor).getDriver().getTitle().equals(windowTitle)) {
                return;
            }
        }


        BrowseTheWeb.as(actor).getDriver().switchTo().window(currentWindowHandle);
    }


    public static SwitchToWindow withTitle(String windowTitle) {
        return new SwitchToWindow(windowTitle);
    }
}