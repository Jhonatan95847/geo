package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SelectID implements Interaction {
    private static final Logger logger = LogManager.getLogger(SelectID.class);
    private final String id;

    // HashMap para almacenar más de 10 valores
    private static final Map<String, String> ID_TYPES = new HashMap<>();

    static {
        ID_TYPES.put("CC", "1");
        ID_TYPES.put("NIT", "2");
        ID_TYPES.put("JE", "3");
        ID_TYPES.put("RUT", "4");
        ID_TYPES.put("TI", "5");
        ID_TYPES.put("NIUP", "6");
        ID_TYPES.put("CE", "7");
        ID_TYPES.put("PAS", "8");
        ID_TYPES.put("PEP", "9");
        ID_TYPES.put("DE", "10");
        ID_TYPES.put("NITPN", "11");
        ID_TYPES.put("PPT", "12");
    }

    public SelectID(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Seleccionando tipo de ID: {}", id);

        String codigoID = ID_TYPES.getOrDefault(id.toUpperCase(), "A");

        actor.attemptsTo(
                EscribirTextoConTeclado.elTexto(codigoID)
        );
    }

    public static SelectID select(String id) {
        return Tasks.instrumented(SelectID.class, id);
    }
}

