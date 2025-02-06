package co.com.colcomercio.geo.utils;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Subject("Execute SQL Query")
public class ExecuteSQLQuery implements Task {
    private final String host;
    private final String port;
    private final String database;
    private final String user;
    private final String password;
    private final String query;

    public ExecuteSQLQuery(String host, String port, String database, String user, String password, String query) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String jdbcUrl = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + database;
        String result = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                result = resultSet.getString(1);  // Obtén el primer resultado como un string
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error executing SQL query: " + e.getMessage());
        }

        // Almacena el resultado en la memoria del actor
        actor.remember("queryResult", result);

    }

    public static ExecuteSQLQuery withParameters(String host, String port, String database, String user, String password, String query) {
        return instrumented(ExecuteSQLQuery.class, host, port, database, user, password, query);
    }
}