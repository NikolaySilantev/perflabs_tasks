package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    private static final String SRC = "poem.txt";
    private static final Integer MIN_DELAY_MS = 1000;
    private static final Integer MAX_DELAY_MS = 3000;



    public static void main( String[] args ) throws IOException, InterruptedException {
        Path source = Paths.get(SRC);

        BufferedReader reader = new BufferedReader(new FileReader(source.toString()));
        String line;

        Queue<String> queue = new LinkedList<>();

        while ((line = reader.readLine()) != null) {
            if (!line.isBlank()) {
                queue.add(line);
            }
        }
        reader.close();

        while (!queue.isEmpty()) {
            Thread.sleep((long)(Math.random() * (MAX_DELAY_MS - MIN_DELAY_MS) + MIN_DELAY_MS));
            System.out.println(queue.poll());
        }
    }
}
