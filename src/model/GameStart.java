package model;

import view.InGameText;
import view.OutputView;
import view.InputNumber;
public class GameStart {
    InputNumber input = new InputNumber();
    OutputView output = new OutputView();
    StrikeBallCounter strikeBallCount = new StrikeBallCounter();

    private int strike;
    private int ball;
    private int nothing;
    private boolean isContinue = true;
    private String userInput;

    public void startGame(String answer, int setBall) {
        while(isContinue) {
            playGame(answer, setBall);
            retry(setBall);
        }
        initContinue();
    }

    private void playGame(String answer, int setBall) {
        InGameText.inputNumber();
        userInput = input.getNumber();
        errorCheck(setBall, userInput);
        strikeBallCount.countStrikeBall(answer, userInput);
        bringCount();
        output.ballCountView(strike, ball, nothing, setBall);
    }

    private void errorCheck(int setBall, String userInput) {
        InputValidator.onlyNumber(setBall, userInput);
        InputValidator.checkEachDiffNum(userInput);
    }

    private void bringCount() {
        this.strike = strikeBallCount.getStrike();
        this.ball = strikeBallCount.getBall();
        this.nothing = strikeBallCount.getNothing();
    }

    private void retry(int setBall) {
        if (strike == setBall) {
            isContinue = false;
        }
    }

    private void initContinue() {
        isContinue = true;
    }

}
