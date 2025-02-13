package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class SelectFranquicia implements Interaction {
    private final String franquicia;

    // Mapeo de franquicias con la cantidad de veces que se debe presionar "Down"
    private static final Map<String, Integer> OPCIONES = new HashMap<>();
    static {
        OPCIONES.put("Mastercard", 0);
        OPCIONES.put("Visa", 1);
        OPCIONES.put("Amex", 2);
        OPCIONES.put("B Superior", 3);
        OPCIONES.put("Credencial", 4);
        OPCIONES.put("Especifica", 5);
        OPCIONES.put("Servibanca", 6);
        OPCIONES.put("Visa Debit", 7);
        OPCIONES.put("Maestro", 8);
    }

    public SelectFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int movimientos = OPCIONES.getOrDefault(franquicia, 0); // Si no está en el mapa, asume 0 movimientos

        for (int i = 0; i < movimientos; i++) {
            actor.attemptsTo(PresionarTecla.conCodigo(KeyEvent.VK_DOWN));
        }
        actor.attemptsTo(PresionarTecla.conCodigo(KeyEvent.VK_ENTER)); // Confirmar selección
    }

    public static SelectFranquicia select(String franquicia) {
        return Tasks.instrumented(SelectFranquicia.class, franquicia);
    }
}