package service;

import view.ChoiceBall;
import view.InGameText;
import view.InputNumber;

public class ViewService {
    ChoiceBall choiceBall = new ChoiceBall();
    InputNumber inputNumber = new InputNumber();

    public int choiceBall() {
        InGameText.choiceBall();
        return choiceBall.getBall();
    }

    public String userNumber() {
        InGameText.inputNumber();
        return inputNumber.getNumber();
    }
}
