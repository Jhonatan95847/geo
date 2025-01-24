package co.com.colcomercio.geo.stepdefinitions;


import co.com.colcomercio.geo.interactions.OpenWindowsDriver;
import co.com.colcomercio.geo.tasks.LoginGeo;
import co.com.colcomercio.geo.tasks.LoginOnVnc;
import co.com.colcomercio.geo.tasks.OpenGeoPos;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Login {

    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("que un usuario ingresa a la caja y selecciona tipo de documento {string}")
    public void     queUnUsuarioIngresaaLaCajaySeleccionaTipoDeDocumento(String documento) {
        actorWindows.wasAbleTo(
                OpenWindowsDriver.openTheApp("C:\\Program Files\\VNC Ultravnc\\vncviewer64.exe"),
                LoginOnVnc.loginOnVnc(),
                OpenGeoPos.open(),
                LoginGeo.open()
        );
    }
}
