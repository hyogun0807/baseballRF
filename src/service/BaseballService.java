package service;

import model.AnswerGenerator;

public class BaseballService {
    AnswerGenerator answerGenerate = new AnswerGenerator();

    public void generateAnswerBy(int ballSize) {
        answerGenerate.generateAnswerBy(ballSize);
    }

    public boolean matchNumber(String userNumber) {
        // 시버스 동작
        return true;
    }
}
