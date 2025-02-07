package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectID implements Interaction {
    private static final Logger logger = LogManager.getLogger(SelectID.class);
    private final String id;

    public SelectID(String id){
        this.id=id;
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
            case "NITPN":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("11")
                );
                break;
                case "PPT":
                actor.attemptsTo(
                        EscribirTextoConTeclado.elTexto("12")
                );
                break;
        }
    }
    public static SelectID select(String id){
        return Tasks.instrumented(SelectID.class,id);
    }
}
