package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.interactions.PresionarTecla;
import io.cucumber.java.an.Y;
import net.serenitybdd.screenplay.Actor;

import java.awt.event.KeyEvent;

public class PayProcess {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Y("desea realizar el pago {string} donacion con metodo de pago {string}")
    public void     deseaRealizarElPagoDonacionConMetodoDePago(String donacion,String payMethod) {
        actorWindows.wasAbleTo(
                PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE),
                EscribirTextoConTeclado.elTexto("1"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                EscribirTextoConTeclado.elTexto("900000"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_S),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(5)
        );
    }
}
