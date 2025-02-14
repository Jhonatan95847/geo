package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.PresionarTecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

public class AddVendedorAsesor implements Task {

    private final String convenio;

    public AddVendedorAsesor(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (convenio.equals("sin")){
            actor.attemptsTo(
                    //EscribirTextoConTeclado.elTexto("s"), para ak33
                    ValidateTextOnScreen.contains("Seleccione"), // Seleccione un Convenio
                    PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
            );
        } else if (convenio.equals("con")) {
            actor.attemptsTo(
                    //EscribirTextoConTeclado.elTexto("s"), para ak33
                    ValidateTextOnScreen.contains("Seleccione"),
                    PresionarTecla.conCodigo(KeyEvent.VK_ASTERISK)
            );
        } else if (convenio.equals("NA")) {
            actor.attemptsTo(
                    EscribirTextoConTeclado.elTexto("s")
            );
        }
        actor.wasAbleTo(
                ValidateTextOnScreen.contains("ende"), // vendedor
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                ValidateTextOnScreen.contains("ende"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                ValidateTextOnScreen.contains("eso"),  //Asesor
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                ValidateTextOnScreen.contains("eso"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
        );
    }
    public static AddVendedorAsesor agregate(String convenio){
        return Tasks.instrumented(AddVendedorAsesor.class, convenio);
    }
}
