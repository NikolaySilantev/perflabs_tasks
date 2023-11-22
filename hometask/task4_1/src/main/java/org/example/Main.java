package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{

    private static final String SRC = "poem.txt";
    private static final String TARGET = "part";
    private static final String EXTENSION = ".txt";



    public static void main( String[] args ) throws IOException {
        Path source = Paths.get(SRC);

        BufferedReader reader = new BufferedReader(new FileReader(source.toString()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");

        Integer counter = 1;
        while ((line = reader.readLine()) != null) {
            if (!line.isBlank()) {
                stringBuilder.append(line + ls);
            }
            else {
                line = stringBuilder.toString();
                BufferedWriter writer = new BufferedWriter(new FileWriter(TARGET + counter + EXTENSION));
                writer.write(line);
                writer.close();
                stringBuilder.delete(0, stringBuilder.length());
                counter++;
            }
        }
        reader.close();
    }
}
