package view;

import java.util.Scanner;

public class SelectCoin {
    private int userCoin;
    private boolean coin;

//    public boolean selectCoin() {
//        inputCoin();
//        coinErrorCheck(userCoin);
//        setCoin(userCoin);
//        return coin;
//    }
    public void userCoin() {
        inputCoin();
    }

    public int saveCoin() {
        return userCoin;
    }
    private void inputCoin() {
        Scanner coinInput = new Scanner(System.in);
        userCoin = coinInput.nextInt();
        coinErrorCheck(userCoin);
//        return userCoin;
    }

    private void coinErrorCheck(int userCoin) {
        if (userCoin != 1 && userCoin != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void setCoin(int userCoin) {
        coin = userCoin == 1;
    }
}
