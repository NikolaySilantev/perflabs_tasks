public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] circularArray = new int[n];

        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        StringBuilder answer = new StringBuilder();

        System.out.println(answer);

        int i = 0;

        do {
            answer.append(circularArray[i]);
            i = (i + m - 1) % n;
        } while (i != 0);
        System.out.println(answer);
    }
}