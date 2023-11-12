package org.example;

import org.example.data.OsbbManager;
import org.flywaydb.core.Flyway;

import static org.example.Config.*;

public class App {
    private App() {
    }
    public static void main(final String[] args) {

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();

        try (OsbbManager manager= new OsbbManager();) {
            manager.init();
            manager.SqlZapit();
        }
    }
}
