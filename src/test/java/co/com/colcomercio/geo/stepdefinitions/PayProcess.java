package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.interactions.*;
import co.com.colcomercio.geo.tasks.ComfirmAndPrint;
import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import io.cucumber.java.an.Y;
import net.serenitybdd.screenplay.Actor;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.geo.utils.WaitingTime.MEDIUM_TIME;

public class PayProcess {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Y("desea realizar el pago {string} donacion con metodo de pago {string}")
    public void     deseaRealizarElPagoDonacionConMetodoDePago(String donacion,String payMethod) {
       actorWindows.wasAbleTo(
               SelectDonacion.agregate(donacion),
               SelectPayMethod.select(payMethod)
       );
       if (payMethod.equals("efectivo")){
           actorWindows.wasAbleTo(
                   PayCash.pay()
           );
       } else if (payMethod.equals("Credibanco")) {
           actorWindows.wasAbleTo(
                   PayCredibanco.pay()
           );
       }
       actorWindows.attemptsTo(
        ComfirmAndPrint.confirm()
        );
    }

    @Y("desea realizar el pago {string} donacion con tarjeta {string} de la franquicia {string}")
    public void deseaRealizarElPagoDonacionConTarjetaDeLaFranquicia(String donacion, String tarjeta, String franquicia) {
        actorWindows.wasAbleTo(
                SelectDonacion.agregate(donacion),
                SelectPayMethod.select("tarjeta"),
                PayRedeban.pay(tarjeta,franquicia),
                ComfirmAndPrint.confirm()
        );


    }
}
