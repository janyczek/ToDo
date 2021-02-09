package main.window;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public void write(String text){
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

    }
}
