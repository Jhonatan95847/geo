package co.com.colcomercio.geo.tasks;

import co.com.colcomercio.geo.interactions.EscribirTextoConTeclado;
import co.com.colcomercio.geo.interactions.PerformWait;
import co.com.colcomercio.geo.interactions.PresionarTecla;
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
    public AddCliente(String cliente, String id){
        this.id=id;
        this.cliente=cliente;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("seleccionando tipo de id");
        switch (id) {
            case "CC":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("1")
                );
                break;
            case "NIT":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("2")
                );
                break;
            case "Juridico Extranjeto":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("3")
                );
                break;
            case "RUT":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("4")
                );
                break;
            case "TI":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("5")
                );
                break;
            case "NIUP":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("6")
                );
                break;
            case "CE":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("7")
                );
                break;
            case "PAS":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("8")
                );
                break;
            case "PEP":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("9")
                );
                break;
            case "DE":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("10")
                );
                break;
            case "NIT PN":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("11")
                );
                break;
        }
        actor.attemptsTo(
                PerformWait.wait(5),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
        );
        logger.info("agregando numero de id");
        if (cliente.equals("registrado")){
            actor.attemptsTo(
                    EscribirTextoConTeclado.elTexto("1234567890")
            );
        } else if (cliente.equals("nuevo")){
            actor.attemptsTo(
                    EscribirTextoConTeclado.elTexto("1237890")
            );
        }
        actor.attemptsTo(
                PerformWait.wait(5),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PresionarTecla.conCodigo(KeyEvent.VK_F9),
                PerformWait.wait(10)
        );
    }
    public static AddCliente agregate(String cliente, String id){
        return Tasks.instrumented(AddCliente.class, cliente,id);
    }
}
