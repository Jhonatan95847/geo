package co.com.colcomercio.geo.utils;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarBaseDeDatos implements Task {
    private final String host;
    private final String baseDatos;
    private final String usuario;
    private final String pass;
    private final String consulta;
    private final String claveRecuerdo; // Nombre con el que se recordará el resultado

    public ConsultarBaseDeDatos(String host, String baseDatos, String usuario, String pass, String consulta, String claveRecuerdo) {
        this.host = host;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.pass = pass;
        this.consulta = consulta;
        this.claveRecuerdo = claveRecuerdo;
    }

    @Override
    @Subject("Ejecutar una consulta en la base de datos Oracle y recordar el resultado")
    public <T extends Actor> void performAs(T actor) {
        String urlConexion = "jdbc:oracle:thin:@" + host + ":1521:" + baseDatos;
        String valorObtenido ="";

        try (Connection conexion = DriverManager.getConnection(urlConexion, usuario, pass);
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery(consulta)) {

            if (resultado.next()) {
                valorObtenido = resultado.getString(1); // Obtiene el primer valor de la consulta
                System.out.println("Factura anterioa: " + valorObtenido);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al ejecutar la consulta en Oracle", e);
        }
        actor.remember(claveRecuerdo, valorObtenido); // Guarda el resultado en la memoria del actor
    }

    public static ConsultarBaseDeDatos conParametros(String host, String baseDatos, String usuario, String contraseña, String consulta, String claveRecuerdo) {
        return instrumented(ConsultarBaseDeDatos.class, host, baseDatos, usuario, contraseña, consulta, claveRecuerdo);
    }
}
