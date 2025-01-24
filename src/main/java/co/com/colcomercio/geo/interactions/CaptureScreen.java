package co.com.colcomercio.geo.interactions;


import co.com.colcomercio.geo.exceptions.TesseractExceptions;
import co.com.colcomercio.geo.utils.ScreenCapture;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CaptureScreen implements Interaction {
    private final String name ;

    public CaptureScreen(String name) {
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }
    public  static CaptureScreen captureScreen(String name){
        return Tasks.instrumented(CaptureScreen.class,name);
    }
}

