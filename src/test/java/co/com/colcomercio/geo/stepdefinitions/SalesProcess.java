package co.com.colcomercio.geo.stepdefinitions;


import co.com.colcomercio.geo.tasks.AddVendedorAsesor;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

public class SalesProcess {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("selecciona {string} convenio y agrega el vendedor y el asesor")
    public void     agregaProductosDeTipo(String convenio) {
        actorWindows.wasAbleTo(
                AddVendedorAsesor.agregate(convenio)
        );


    }


}
