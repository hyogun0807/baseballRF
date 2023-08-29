package model;

public class StrikeBallCounter {
    private int strike;
    private int ball;
    private int nothing;

    public void matchNumber(String answer, String userNumber) {
        countBall(answer, userNumber);
    }

    public void initBallCount() {
        strike = 0;
        ball = 0;
        nothing = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return this.nothing;
    }

    private void plusStrike() {
        strike++;
    }

    private void plusBall() {
        ball++;
    }

    private void plusNothing() {
        nothing++;
    }

    private void countBall(String answerGenerator, String userInputNumber) {
        for (int i = 0; i < userInputNumber.length(); i++) { // for문 여러개
            char userNumber = userInputNumber.charAt(i);
            char answerNumber = answerGenerator.charAt(i);

            if (userNumber == answerNumber) {
                plusStrike(); // 인덱스와 숫자가 일치하면 스트라이크 증가
            } else if (answerGenerator.contains(String.valueOf(userNumber))) {
                plusBall();   // 숫자는 포함되지만 인덱스가 일치하지 않으면 볼 증가
            } else {
                plusNothing();
            }
        }
    }
}