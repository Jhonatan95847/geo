package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class CloseWindow implements Interaction {

    private final String windowTitle;

    public CloseWindow(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String currentWindowHandle = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                driver.close();
                return;
            }
        }

    }

    public static CloseWindow withTitle(String windowTitle) {
        return new CloseWindow(windowTitle);
    }
}

