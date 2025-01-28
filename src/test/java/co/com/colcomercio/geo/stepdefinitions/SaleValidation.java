package co.com.colcomercio.geo.stepdefinitions;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

public class SaleValidation {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Entonces("deberia generarse la factura de pago")
    public void deberiaGenerarseLaFacturaDePago(String n,String normal) {
        actorWindows.wasAbleTo(

        );
    }
}
