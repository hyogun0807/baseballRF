package service;

import model.AnswerGenerator;

public class BaseballService {
    AnswerGenerator answerGenerate = new AnswerGenerator();

    public void generateAnswerBy(int ballSize) {
        answerGenerate.generateAnswerBy(ballSize);
    }
}
