package org.ibs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DBTests {

    static Connection connection;
    static Statement statement;

    @BeforeAll
    static void beforeTests() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/mem:testdb", "user", "pass");
        statement = connection.createStatement();
    }

    @Test
    void getAllProductsTest() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM FOOD;");
        int count = 0;
        while (resultSet.next()){
            count = resultSet.getInt("Count(*)");
        }
        Assertions.assertTrue(count >= 4);
    }

    @Test
    void addFruitTest() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM FOOD");

        int count1 = 0;
        while (resultSet.next()){
            count1 = resultSet.getInt("Count(*)");
        }

        PreparedStatement pt = connection.prepareStatement("INSERT INTO FOOD (FOOD_ID, FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC) VALUES (?,?,?,?)");
        pt.setInt(1, count1+1);
        pt.setString(2, "Мандарин");
        pt.setString(3, "FRUIT");
        pt.setInt(4, 1);
        pt.executeUpdate();

        resultSet = statement.executeQuery("SELECT COUNT(*) FROM FOOD");

        int count2 = 0;
        while (resultSet.next()){
            count2 = resultSet.getInt("Count(*)");
        }

        Assertions.assertTrue(count2 > count1);
    }

    @Test
    void deleteLastProductTest() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM FOOD");

        int count1 = 0;
        while (resultSet.next()){
            count1 = resultSet.getInt("Count(*)");
        }


        PreparedStatement pt = connection.prepareStatement("DELETE FROM FOOD WHERE FOOD_ID = ?");
        pt.setInt(1, count1);
        pt.executeUpdate();

        resultSet = statement.executeQuery("SELECT COUNT(*) FROM FOOD");

        int count2 = 0;
        while (resultSet.next()){
            count2 = resultSet.getInt("Count(*)");
        }

        Assertions.assertTrue(count2 < count1);
    }
}
