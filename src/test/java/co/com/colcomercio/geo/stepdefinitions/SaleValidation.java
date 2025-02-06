package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.tasks.DownloadFileViaSFTP;
import co.com.colcomercio.geo.utils.ExecuteSQLQuery;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

public class SaleValidation {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Entonces("deberia generarse la factura de pago")
    public void deberiaGenerarseLaFacturaDePago(String n,String normal) {
        actorWindows.wasAbleTo(
                DownloadFileViaSFTP.from(
                        "sftp.servidor.com", // Host del servidor
                        22,                 // Puerto
                        "usuario",          // Usuario
                        "contraseña",       // Contraseña
                        "/ruta/remota",     // Ruta de la carpeta remota
                        "C:\\ruta\\local"   // Ruta de la carpeta local
                ),
                ExecuteSQLQuery.withParameters(

                        "10.181.11.114",     // Host
                        "1521",          // Puerto
                        "gpossrv",        // Base de datos o schema
                        "ACNGEOPOS",            // Usuario
                        "ACNG30p0s$",  // Contraseña
                        "consulta" // Consulta SQL
                )
        );
    }
}
