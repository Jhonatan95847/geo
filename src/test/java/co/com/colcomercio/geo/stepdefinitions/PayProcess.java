package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.interactions.*;
import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import io.cucumber.java.an.Y;
import net.serenitybdd.screenplay.Actor;

import java.awt.event.KeyEvent;

public class PayProcess {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Y("desea realizar el pago {string} donacion con metodo de pago {string}")
    public void     deseaRealizarElPagoDonacionConMetodoDePago(String donacion,String payMethod) {
        if (donacion.equals("sin")){
            actorWindows.wasAbleTo(
                    PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
            );
        } else if (donacion.equals("con")) {
            actorWindows.wasAbleTo(
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
            );
        }
        actorWindows.wasAbleTo(
                PerformWait.wait(3),
                ValidateTextOnScreen.contains("Forma de Pago")
        );
        if (payMethod.equals("efectivo")){
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("1")
            );
        } else if (payMethod.equals("efectivo dolares")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("1B")
            );
        } else if (payMethod.equals("credibanco")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("9")
            );
        } else if (payMethod.equals("redeban")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("12")
            );
        } else if (payMethod.equals("efectivo BR")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("13")
            );
        } else if (payMethod.equals("efectivo B50")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("14")
            );
        } else if (payMethod.equals("efectivo BD")) {
            actorWindows.wasAbleTo(
                    EscribirTextoConTeclado.elTexto("15")
            );
        }
        actorWindows.wasAbleTo(
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(2),
                //ValidateTextOnScreen.contains("Ingrese el monto"),
                EscribirTextoConTeclado.elTexto("2000000"),
                PerformWait.wait(2),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(3),
                ValidateTextOnScreen.contains("Con"),
                PresionarTecla.conCodigo(KeyEvent.VK_S),
                PerformWait.wait(10),
                ValidateTextOnScreen.contains("tipo"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(1)
                //CloseWindow.withTitle("pos@alk33-03qa1 ")
        );
    }
}
