package controller;

import model.*;
import service.BaseballService;
import view.InGameText;
import view.SelectCoin;

/**
 * 모-뷰 서로 데이터 전달
 *
 */
public class BaseballGameController {

    public BaseballGameController(BaseballService ballService) {
        this.ballService = ballService;
    }

    BaseballService ballService = new SoccerService();





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

    public void generateAnswer(String userBallSize) {
        // 여기서 생성자를 통해 생성을 해주던지 or 미리 위에처럼 생성을 하고

        int ballSize = Integer.valueOf(userBallSize);
        ballService.generateAnswerBy(ballSize);
    }

    public boolean matchNumber(String userNumber) {
        // 예외
        return ballService.matchNumber(userNumber);
    }

    ////////////////////
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



