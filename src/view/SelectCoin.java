package view;

import java.util.Scanner;

public class SelectCoin {
    private int userCoin;
    private boolean coin;

    public boolean selectCoin() {
        inputCoin();
        coinErrorCheck(userCoin);
        setCoin(userCoin);
        return coin;
    }

    private void inputCoin() {
        Scanner coinInput = new Scanner(System.in);
        userCoin = coinInput.nextInt();
    }

    private void coinErrorCheck(int userCoin) {
        if (userCoin != 1 && userCoin != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void setCoin(int userCoin) {
        coin = userCoin == 1;
    }
}
