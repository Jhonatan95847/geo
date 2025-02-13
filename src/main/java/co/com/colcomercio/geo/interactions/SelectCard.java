package co.com.colcomercio.geo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;
import java.util.Map;

public class SelectCard implements Interaction {

    private final String tarjeta;

    private static final Map<String, Integer> OPCIONES = Map.of(
            "credito", 0,
            "debito", 1,
            "EL", 2,
            "CC", 3,
            "AH", 4
    );

    public SelectCard(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int movimientos = OPCIONES.getOrDefault(tarjeta.toLowerCase(), 0);

        // Presionar "Abajo" las veces necesarias
        for (int i = 0; i < movimientos; i++) {
            actor.attemptsTo(PresionarTecla.conCodigo(KeyEvent.VK_DOWN));
        }

        // Confirmar selección con Enter
        actor.attemptsTo(PresionarTecla.conCodigo(KeyEvent.VK_ENTER));
    }

    public static SelectCard select(String tarjeta) {
        return Tasks.instrumented(SelectCard.class, tarjeta);
    }
}