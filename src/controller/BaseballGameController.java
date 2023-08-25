package controller;

import model.*;
import view.InGameText;
import view.SelectCoin;


public class BaseballGameController {
    private int setBall;
    private boolean coin = true;
    private String answer;
    ChoiceBall ballchoice = new ChoiceBall();
    AnswerGenerator answerGenerate = new AnswerGenerator();
    GameStart gameStart = new GameStart();
    SelectCoin selectCoin = new SelectCoin();

    public BaseballGameController() {
        while (coin) {
            gameContinue();
            gameEndView();
            coin = getCoin();
        }
    }

    private void gameContinue() {
        getBall();
        makeAnswer();
        startGame(answer, setBall);
    }

    private void getBall() {
        InGameText.choiceBall();
        setBall = ballchoice.getBall();
        System.out.println(setBall);
    }

    private void makeAnswer() {
        answerGenerate.getNumber(setBall);
        answer = answerGenerate.getAnswer();
        System.out.println(answer);
    }

    private void startGame(String answer, int setBall) {
        gameStart.startGame(answer, setBall);
    }

    private void gameEndView() {
        InGameText.correctAnswer(setBall);
        InGameText.reGameText();
    }

    private boolean getCoin() {
        coin = selectCoin.selectCoin();
        return coin;
    }
}



