package org.example.data;

import org.apache.log4j.Logger;
import org.example.*;
import org.flywaydb.core.Flyway;

import static org.example.Config.*;

public class OsbbCrud {

    private static final Logger logger = Logger.getLogger(OsbbCrud.class);

    public void init(){

        logger.debug("Flyway migration execute");
        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();
    }
}
