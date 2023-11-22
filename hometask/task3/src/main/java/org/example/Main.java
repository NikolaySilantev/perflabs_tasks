package org.example;

import java.util.Scanner;

public class Main {

    /**
        The program works as follows:
        The user enters a number and the number is checked.
        If any errors are found, corresponding messages are displayed.
        If the user enters an exit command, the loop is interrupted.
    **/

    public static void main(String[] args) {
        System.out.println("Для выхода из программы используйте команду 'exit'.");
        System.out.println("Введите номер...");
        Scanner scanner = new Scanner(System.in);
        String str;

        while (true) {
            if (scanner.hasNext()) {
                str = scanner.next();
                if (str.equals("exit")) {
                    System.out.println("Завершение работы...");
                    break;
                }
                str = NumberChecker.preprocessNumber(str);
                if (NumberChecker.formatCheck(str)) {
                    System.out.println(NumberChecker.findRegion(str));
                } else {
                    System.out.println(NumberChecker.findInvalidSymbols(str));
                }
            }
        }

    }
}
