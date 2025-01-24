package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.utils.DeleteTicketRecover;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class CleanRegister implements Interaction {

    public CleanRegister() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DeleteTicketRecover.deleteTheFolderSesions();
    }
    public static CleanRegister deleteTheSessions(){
        return Tasks.instrumented(CleanRegister.class);
    }
}