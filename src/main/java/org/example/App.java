package org.example;

import org.apache.log4j.Logger;
import org.example.data.OsbbCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws SQLException {
        logger.info("The program has started");
        new OsbbCrud().init();

        String sqlQuery = "SELECT " +
                "p.id AS 'ID власника', " +
                "p.name AS 'ПІБ власника', " +
                "p.tel_number AS 'Номер телефону', " +
                "p.parking AS 'Має паркомісце', " +
                "f.number AS 'Номер квартири', " +
                "f.sq AS 'Площа квартири', " +
                "b.house AS 'Номер будинку', " +
                "b.street AS 'Вулиця' " +
                "FROM people p " +
                "JOIN people_owner po ON p.id = po.people_id_owner " +
                "JOIN flats f ON p.flats_id = f.id " +
                "JOIN buildings b ON f.building_id = b.id " +
                "WHERE po.owner = 0 " +
                "AND (SELECT COUNT(*) FROM flats WHERE flats_id = f.id) < 2;";


        Connection connection = DriverManager.getConnection(Config.jdbcUrl, Config.username, Config.password);

        try {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID власника");
                String name = resultSet.getString("ПІБ власника");
                String telNumber = resultSet.getString("Номер телефону");
                int parking = resultSet.getInt("Має паркомісце");
                int number = resultSet.getInt("Номер квартири");
                double sq = resultSet.getDouble("Площа квартири");
                int house = resultSet.getInt("Номер будинку");
                String street = resultSet.getString("Вулиця");

                System.out.println("ID власника: " + id);
                System.out.println("ПІБ власника: " + name);
                System.out.println("Номер телефону: " + telNumber);
                System.out.println("Має паркомісце: " + parking);
                System.out.println("Номер квартири: " + number);
                System.out.println("Площа квартири: " + sq);
                System.out.println("Номер будинку: " + house);
                System.out.println("Вулиця: " + street);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            connection.close();
        }
    }
}
