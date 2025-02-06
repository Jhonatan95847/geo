package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.models.users.Users;
import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.DataGenerator.DataGeneratorDate;
import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.geo.utils.WaitingTime.MEDIUM_TIME;

public class AddDataCliente implements Interaction {
    private final String cliente;
    private final Users dataUsers;
    String username = DataGeneratorDate();
    public AddDataCliente(String cliente, Users dataUsers) {
        this.cliente = cliente;
        this.dataUsers = dataUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (cliente.equals("registrado")){
            actor.attemptsTo(
                    EscribirTextoConTeclado.elTexto(dataUsers.getDataUsers().getIdUser()),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    //ValidateTextOnScreen.contains("Reg"),
                    //PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    //PerformWait.wait(4),
                    ValidateTextOnScreen.contains("Cliente con"),
                    PresionarTecla.conCodigo(KeyEvent.VK_F9),
                    PerformWait.wait(LOW_TIME)
            );
        } else if (cliente.equals("nuevo")){
            actor.attemptsTo(
                    EscribirTextoConTeclado.elTexto(username),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    ValidateTextOnScreen.contains("ente"),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    EscribirTextoConTeclado.elTexto("Jhonatan"),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    EscribirTextoConTeclado.elTexto("Automtizacion"),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(MEDIUM_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(MEDIUM_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    EscribirTextoConTeclado.elTexto("Calle 13 nro 12 24"),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    EscribirTextoConTeclado.elTexto("7456798"),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(3),
                    EscribirTextoConTeclado.elTexto("3207456798"),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_DOWN),
                    PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                    PerformWait.wait(LOW_TIME),
                    PresionarTecla.conCodigo(KeyEvent.VK_F9),
                    EscribirTextoConTeclado.elTexto("n"),
                    PerformWait.wait(LOW_TIME)
            );
        }
    }
    public static AddDataCliente agregate(String cliente, Users users){
        return Tasks.instrumented(AddDataCliente.class, cliente, users);
    }
}
