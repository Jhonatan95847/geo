package co.com.colcomercio.geo.stepdefinitions;


import co.com.colcomercio.geo.interactions.GoToStart;
import co.com.colcomercio.geo.interactions.OpenWindowsDriver;
import co.com.colcomercio.geo.tasks.*;
import co.com.colcomercio.geo.tasks.DownloadFileViaSFTP;
import co.com.colcomercio.geo.tasks.DownloadFileViaSFTP;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Login {

    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("que un cliente {string} realiza una compra y selecciona documento {string}")
    public void     queUnUsuarioIngresaaLaCajaySeleccionaTipoDeDocumento(String cliente,String id) {
        actorWindows.wasAbleTo(
                OpenWindowsDriver.openTheApp("C:\\Program Files\\VNC Ultravnc\\vncviewer64.exe"),
                LoginOnVnc.loginOnVnc(),
                OpenGeoPos.open(),
                GoToStart.go(),
                AddCliente.agregate(cliente,id)
        );
    }
}
