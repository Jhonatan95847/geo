package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.PerformWait;
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
                    PerformWait.wait(2),
                    EscribirTextoConTeclado.elTexto("s"),
                    PerformWait.wait(2),
                    ValidateTextOnScreen.contains("Seleccione un Convenio"),
                    PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
            );
        } else if (convenio.equals("con")) {
            actor.attemptsTo(
                    PerformWait.wait(2),
                    EscribirTextoConTeclado.elTexto("s"),
                    PerformWait.wait(2),
                    ValidateTextOnScreen.contains("Seleccione un Convenio"),
                    PresionarTecla.conCodigo(KeyEvent.VK_ASTERISK)
            );
        }
        actor.wasAbleTo(
                PerformWait.wait(2),
                ValidateTextOnScreen.contains("nde"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(2),
                ValidateTextOnScreen.contains("seso"),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
        );
    }
    public static AddVendedorAsesor agregate(String convenio){
        return Tasks.instrumented(AddVendedorAsesor.class, convenio);
    }
}
