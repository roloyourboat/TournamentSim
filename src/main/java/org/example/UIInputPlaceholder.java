package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class UIInputPlaceholder {


    public static int getIntFromInput(String inputPrompt, int[] acceptableOptions) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(inputPrompt);

            int choice = scanner.nextInt();

            if(Arrays.stream(acceptableOptions).anyMatch(i -> i == choice)) {
                return choice;
            }

        }

    }
}
