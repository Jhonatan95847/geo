package co.com.colcomercio.geo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CloseVNC implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Ejecutar el comando TASKKILL
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "TASKKILL /IM vncviewer64.exe /F");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor(); // Espera a que termine la ejecución del comando
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CloseVNC closeVNCProcess() {
        return instrumented(CloseVNC.class);
    }
}