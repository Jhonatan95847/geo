package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.OpenWindowsDriver;
import co.com.colcomercio.geo.interactions.PresionarTecla;
import co.com.colcomercio.geo.tasks.AddCliente;
import co.com.colcomercio.geo.tasks.LoginGeo;
import co.com.colcomercio.geo.tasks.LoginOnVnc;
import co.com.colcomercio.geo.tasks.OpenGeoPos;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

import java.awt.event.KeyEvent;

public class AddProducts {

    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("agrega {string} productos de tipo {string}")
    public void     agregaProductosDeTipo(String n,String normal) {
        actorWindows.wasAbleTo(
                EscribirTextoConTeclado.elTexto("8806098432516"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_F9)

        );
    }
}
