package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.*;
import co.com.colcomercio.geo.models.users.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.KeyEvent;



public class AddCliente implements Task {
    private static final Logger logger = LogManager.getLogger(AddCliente.class);
    private final String id;
    private final String cliente;
    private Users dataUsers;

    public AddCliente(String cliente, String id, Users dataUsers){
        this.id=id;
        this.cliente=cliente;
        this.dataUsers = dataUsers;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectID.select(id),
                PerformWait.wait(1),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
                //PerformWait.wait(2),
                //ValidateTextOnScreen.contains("Ingrese")
        );
        logger.info("agregando numero de id");

        actor.attemptsTo(
                AddDataCliente.agregate(cliente,dataUsers)
        );
    }
    public static AddCliente agregate(String cliente, String id, Users dataUsers){
        return Tasks.instrumented(AddCliente.class, cliente,id, dataUsers);
    }
}
