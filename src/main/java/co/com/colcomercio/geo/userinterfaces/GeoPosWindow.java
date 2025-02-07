package co.com.colcomercio.geo.userinterfaces;


import co.com.colcomercio.geo.models.vnc.Vnc;
import co.com.colcomercio.geo.utils.GetDataModel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class GeoPosWindow extends PageObject {

    public static Target LOCAL_POS = initLocalPos();

    public static final Target BUTTON_MAX = Target.the("Button for maximize the window").located(By.name("Maximizar"));
    public static final Target BUTTON_CLOSE = Target.the("Button for Close the window").located(By.name("Cerrar"));

    public static final Target BUTTON_RESTORE = Target.the("Minimize window button").located(By.name("Restaurar"));

    private static Target initLocalPos() {
        //String dynamicName = Serenity.sessionVariableCalled("host") + " (x0vncserver): RealVNC Viewer";
        return Target.the("Window for billing pos").located(By.name("pos@alk33-03qa1 "));
    }

    public static void updateLocalPos() {
        LOCAL_POS = initLocalPos();
    }
}
