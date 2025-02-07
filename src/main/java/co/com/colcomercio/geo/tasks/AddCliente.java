package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.*;
import co.com.colcomercio.geo.models.newUsers.NewUsers;
import co.com.colcomercio.geo.models.users.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;


public class AddCliente implements Task {
    private static final Logger logger = LogManager.getLogger(AddCliente.class);
    private final String id;
    private final String cliente;
    private final Users dataUsers;
    private final NewUsers dataNewUsers;

    public AddCliente(String cliente, String id, Users dataUsers, NewUsers dataNewUsers){
        this.id=id;
        this.cliente=cliente;
        this.dataUsers = dataUsers;
        this.dataNewUsers = dataNewUsers;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectID.select(id),
                PerformWait.wait(LOW_TIME),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                ValidateTextOnScreen.contains("Ingrese")  //Ingrese el nro. de cliente
        );
        logger.info("agregando numero de id");

        actor.attemptsTo(
                AddDataCliente.agregate(cliente,dataUsers,dataNewUsers)
        );
    }
    public static AddCliente agregate(String cliente, String id, Users dataUsers, NewUsers dataNewUsers){
        return Tasks.instrumented(AddCliente.class, cliente,id, dataUsers, dataNewUsers);
    }
}
