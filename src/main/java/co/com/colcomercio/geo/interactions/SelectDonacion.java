package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.models.productList.ProductList;
import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class SelectDonacion implements Interaction {
    private final String donacion;

    public SelectDonacion(String donacion) {
        this.donacion = donacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //ValidateTextOnScreen.contains("donacion"),
                PerformWait.wait(LOW_TIME)
        );
        if (donacion.equals("sin")){
            actor.wasAbleTo(
                    PresionarTecla.conCodigo(KeyEvent.VK_ESCAPE)
            );
        } else if (donacion.equals("con")) {
            actor.wasAbleTo(
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
            );
        }
    }

    public static SelectDonacion agregate(String donacion){
        return Tasks.instrumented(SelectDonacion.class, donacion);
    }
}
