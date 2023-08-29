package view;

public class OutputView {
    private void outputWithLine(String message) {
        System.out.println(message);
    }

    private void outputNoLine(String message) {
        System.out.print(message);
    }

    private void emptyLine() { outputWithLine(""); }

    private void onlyNothing(int nothing) {
        System.out.println("낫싱");
    }

    private void onlyBall(int ball) {
        System.out.println(ball+"볼");
    }

    private void onlyStrike(int strike) {
        System.out.println(strike+"스트라이크");
    }

    private void ballAndStrike(int ball, int strike) {
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }
//
//    public void userInputMessage(String message) {
//        outputNoLine(message);
//    }
//
//    public void startView(String message) {
//        outputWithLine(message);
//    }
//
//    public void randomAnswer(String answer) {
//        outputWithLine(answer);
//        emptyLine();
//    }
//
//    public void ballChoiceView(String message) { outputNoLine(message); }

    public void ballCountView(int strike, int ball, int nothing, int setBall) {
        if (nothing == setBall) {
            onlyNothing(nothing);
        }
        else if (ball != 0 && strike == 0) {
            onlyBall(ball);
        }
        else if (strike != 0 && ball == 0) {
            onlyStrike(strike);
        }
        else if(strike != 0 && ball != 0) {
            ballAndStrike(ball, strike);
        }
    }
}
