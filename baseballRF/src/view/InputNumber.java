package view;

import java.util.Scanner;

public class InputNumber {
    private Scanner input;

    public String getNumber() {
        input = new Scanner(System.in);
        return input.nextLine();
    }
}