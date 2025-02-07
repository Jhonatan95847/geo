package co.com.colcomercio.geo.stepdefinitions;


import co.com.colcomercio.geo.interactions.GoToStart;
import co.com.colcomercio.geo.interactions.OpenWindowsDriver;
import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.models.newUsers.NewUsers;
import co.com.colcomercio.geo.models.users.Users;
import co.com.colcomercio.geo.models.vnc.Vnc;
import co.com.colcomercio.geo.tasks.*;
import co.com.colcomercio.geo.utils.ConsultarBaseDeDatos;
import co.com.colcomercio.geo.utils.GetDataModel;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import static co.com.colcomercio.geo.utils.Constants.VNC_PATH;


public class Login {

    private String anterior;
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("que un cliente {string} realiza una compra y selecciona documento {string}")
    public void     queUnUsuarioIngresaaLaCajaySeleccionaTipoDeDocumento(String cliente,String id) {

        Users dataUsers = GetDataModel.users(id);
        NewUsers dataNewUsers = GetDataModel.Newusers(id);


        actorWindows.wasAbleTo(
                OpenWindowsDriver.openTheApp(VNC_PATH),
                LoginOnVnc.loginOnVnc(),
                OpenGeoPos.open(),
                GoToStart.go(),
                AddCliente.agregate(cliente,id, dataUsers, dataNewUsers),
                ConsultarBaseDeDatos.conParametros(
                        "10.181.11.114",     // Host
                        "gpossrv",        // Base de datos o schema
                        "ACNGEOPOS",            // Usuario
                        "ACNG30p0s$",  // Contraseña
                        "SELECT MAX(TICKETNUMBER) AS max_ticket FROM GEOPOS.TICKETS WHERE POS = '03'AND LOCALID = '33'",
                        anterior// Consulta SQL
                )
        );
    }

    @Entonces("deberia generarse la factura de pago")
    public void deberiaGenerarseLaFacturaDePago() {

        String valorObtenido = actorWindows.recall(anterior);
        System.out.println("Ticket antiguo: " + valorObtenido);
        // Convertir a entero, sumar 1 y volver a String
        int maxTicketId = Integer.parseInt(valorObtenido);
        int nuevoTicketId = maxTicketId + 1;
        String nuevoTicketIdStr = String.valueOf(nuevoTicketId);

        System.out.println("Nuevo ticket incrementado: " + nuevoTicketIdStr);
        actorWindows.wasAbleTo(
                PerformWait.wait(10),
                ConsultarBaseDeDatos.conParametros(
                        "10.181.11.114",     // Host
                        "gpossrv",        // Base de datos o schema
                        "ACNGEOPOS",            // Usuario
                        "ACNG30p0s$",  // Contraseña
                        "SELECT TICKETNUMBER FROM Geopos.tickets WHERE POS = '03'AND LOCALID = '33' AND TICKETNUMBER = '"+nuevoTicketIdStr+"'",
                        "ticket_nuevo"// Consulta SQL
                )
        );
    }

}
