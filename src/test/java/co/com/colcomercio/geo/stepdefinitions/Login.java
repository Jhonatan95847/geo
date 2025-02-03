package co.com.colcomercio.geo.stepdefinitions;


import co.com.colcomercio.geo.interactions.GoToStart;
import co.com.colcomercio.geo.interactions.OpenWindowsDriver;
import co.com.colcomercio.geo.models.users.Users;
import co.com.colcomercio.geo.tasks.*;
import co.com.colcomercio.geo.utils.GetDataModel;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;


public class Login {
    private Users dataUsers;
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("que un cliente {string} realiza una compra y selecciona documento {string}")
    public void     queUnUsuarioIngresaaLaCajaySeleccionaTipoDeDocumento(String cliente,String id) {

        dataUsers = GetDataModel.users(id);

        actorWindows.wasAbleTo(
                OpenWindowsDriver.openTheApp("C:\\Program Files\\VNC Ultravnc\\vncviewer64.exe"),
                LoginOnVnc.loginOnVnc(),
                OpenGeoPos.open(),
                GoToStart.go(),
                AddCliente.agregate(cliente,id, dataUsers)
        );
    }
}
