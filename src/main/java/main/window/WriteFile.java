package main.window;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class WriteFile {


    public void write(String text, int pro) {

        //WRITE TO FILE .TXT

//        final String file="C:\\Users\\Jan\\Desktop\\ThingsToDo.txt";
//
//        try(
//                var writer=new FileWriter(file, true);
//                var bwxiter=new BufferedWriter(writer);
//                ) {
//
//            bwxiter.write(text);
//            bwxiter.newLine();
//
//        } catch (IOException e) {
//            System.err.println("Something went bad");
//            e.printStackTrace();
//        }

        //WRITE TO DATABASE

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp?serverTimezone=UTC", "root", "jasiek7");
                Statement statement = connection.createStatement();
        ) {
            String insert = String.format("INSERT INTO main_table(priority, name) VALUES (%d,'%s')", pro, text);
            int result = statement.executeUpdate(insert);


//            int num = 13;
//            StringBuilder builder=new StringBuilder();
//            builder.append("\"INSERT INTO main_table(number, priority, name) VALUES (");
//            builder.append(num+", ");
//            builder.append(pro+", ");
//            builder.append("\'"+text+"\'"+")\"");
//            System.out.println(builder.toString());
//            String pomocny=builder.toString();
//            //int result = statement.executeUpdate(builder.toString());
//            int result = statement.executeUpdate(pomocny);
//            num++;
//            System.out.println("Zapisano" + result);

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
