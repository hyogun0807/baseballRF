package view;

import java.util.Scanner;

public class ChoiceBall {
    private Scanner input;
    public int getBall() {
        input = new Scanner(System.in);
        return input.nextInt();
    }
}