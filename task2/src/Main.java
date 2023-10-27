import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static float getDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) {
        float x = 0, y = 0, r = 0;

        String fileName1 = args[0];
        String fileName2 = args[1];

        File file1 = new File(fileName1);
        File file2 = new File(fileName2);

        try {
            Scanner scanner = new Scanner(file1);
            x=scanner.nextFloat();
            y=scanner.nextFloat();
            r=scanner.nextFloat();

        } catch (FileNotFoundException e) {
            System.out.println("File reading error: " + fileName1);
        }

        float[] x_dot = new float[100], y_dot = new float[100];

        int i = 0;
        try {
            Scanner scanner = new Scanner(file2);

            while (scanner.hasNextFloat()) {
                x_dot[i]=scanner.nextFloat();
                y_dot[i]=scanner.nextFloat();
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File reading error: " + fileName1);
        }

        // precision? x-y=0.1^precision
        for (int j = 0; j < i; j++) {
            float distance = getDistance(x, y, x_dot[j], y_dot[j]);
            if (Float.compare(distance, r) == 0) {
                System.out.println("0");
            }
            else if (Float.compare(distance, r) < 0) {
                System.out.println("1");
            }
            else {
                System.out.println("2");
            }
        }
    }
}
