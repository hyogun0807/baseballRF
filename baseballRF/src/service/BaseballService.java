package service;

import model.AnswerGenerator;
import model.StrikeBallCounter;

public class BaseballService {
    AnswerGenerator answerGenerate = new AnswerGenerator();
    StrikeBallCounter strikeBallCounter = new StrikeBallCounter();
    private String answer;
    private String userInput;
    private int strike;
    private int ball;
    private int nothing;

    public void generateAnswer(int gameBallSize) {
        answer = answerGenerate.makeAnswer(gameBallSize);
    }

    public void ballCount(String userInput) {
        showAnswer();
        strikeBallCounter.matchNumber(answer, userInput);
    }

    public int getStrike() {
        return strikeBallCounter.getStrike();
    }

    public int getBall() {
        return strikeBallCounter.getBall();
    }

    public int getNothing() {
        return strikeBallCounter.getNothing();
    }

    public void showAnswer() {
        System.out.println(answer);
    }

    public void initBallCount() {
        strikeBallCounter.initBallCount();
    }
}
