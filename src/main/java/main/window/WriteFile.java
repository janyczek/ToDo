package main.window;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class WriteFile {

    public void write(String text) {
        final String file="C:\\Users\\Jan\\Desktop\\ThingsToDo.txt";

        try(
                var writer=new FileWriter(file, true);
                var bwxiter=new BufferedWriter(writer);
                ) {

            bwxiter.write(text);
            bwxiter.newLine();

        } catch (IOException e) {
            System.err.println("Something went bad");
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp?serverTimezone=UTC", "root", "jasiek7");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT number, priority, name FROM main_table LIMIT 3");) {

            while (resultSet.next()) {
                int firstName = resultSet.getInt("number");
                int lastName = resultSet.getInt("priority");
                String hireDate = resultSet.getString("name");
                System.out.printf("%d %s - data zatrudnienia: %s\n", firstName, lastName, hireDate);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
