package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.Map;

public class SelectPayMethod implements Interaction {
    private static final Map<String, String> PAY_METHODS = new HashMap<>();

    static {
        PAY_METHODS.put("efectivo", "1");
        PAY_METHODS.put("efectivo dolares", "1B");
        PAY_METHODS.put("credibanco", "9");
        PAY_METHODS.put("tarjeta", "12");
        PAY_METHODS.put("efectivo br", "13");
        PAY_METHODS.put("efectivo b50", "14");
        PAY_METHODS.put("efectivo bd", "15");
    }

    private final String payMethod;

    public SelectPayMethod(String payMethod) {
        this.payMethod = payMethod.toLowerCase(); // Normalizamos el texto a minúsculas
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ValidateTextOnScreen.contains("Forma de Pago"));

        // Obtener el código del método de pago, si no existe, asignar "1" como valor por defecto
        String codigoMetodo = PAY_METHODS.getOrDefault(payMethod, "a");

        actor.attemptsTo(EscribirTextoConTeclado.elTexto(codigoMetodo));
    }

    public static SelectPayMethod select(String payMethod) {
        return Tasks.instrumented(SelectPayMethod.class, payMethod);
    }
}
