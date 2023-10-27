import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
//        String fileName = "src/file3.txt";
        File file = new File(fileName);
        ArrayList<Integer> nums = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }

        int m = nums.get(nums.size() / 2);
        int sum = 0;
        for (int num : nums
        ) {
            sum += Math.abs(num - m);
        }
        System.out.println(sum);
    }}