package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.CleanRegister;
import co.com.colcomercio.geo.interactions.SwitchToWindow;
import co.com.colcomercio.geo.interactions.SwitchWindow;
import co.com.colcomercio.geo.models.vnc.Vnc;
import co.com.colcomercio.geo.utils.GetDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.geo.userinterfaces.VncWindow.*;

public class LoginOnVnc implements Task {

    private Vnc dataVnc;

    private static final Logger logger = LogManager.getLogger(LoginOnVnc.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        dataVnc = GetDataModel.vnc("caja_183");
        logger.info("##################################Abriendo VNC");
        actor.attemptsTo(
                Enter.theValue(dataVnc.getDataVnc().getHost()).into(EDIT_BAR),
                Click.on(AUTOSCALE),
                Click.on(CONECT),
                SwitchWindow.switchTheWindow("Root","VNC Authentication   "+dataVnc.getDataVnc().getHost()+":5900"),
                Click.on(PASSWORD),
                Enter.theValue(dataVnc.getDataVnc().getPassword()).into(PASSWORD).thenHit(Keys.ENTER),
                CleanRegister.deleteTheSessions(),
                SwitchToWindow.withTitle(dataVnc.getDataVnc().getNameWindow())
        );
    }
    public static LoginOnVnc loginOnVnc(){
        return Tasks.instrumented(LoginOnVnc.class);
    }
}
