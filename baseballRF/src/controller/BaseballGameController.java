package controller;

import model.*;
import service.BaseballService;
import service.ViewService;
import view.SelectCoin;

///**
// * 모-뷰 서로 데이터 전달
// *
// */
public class BaseballGameController {
    private BaseballService ballService;
    private ViewService viewService;
    private int gameBallSize;
    private String userNumber;
    private SelectCoin selectCoin = new SelectCoin();
    private int coin;

    public BaseballGameController(BaseballService ballService, ViewService viewService) {
        this.ballService = ballService;
        this.viewService = viewService;
    }

    /**
     * controller <-> service <-> repostiroy
     * @return
     */


//
//
//
//
//
//    private int setBall;
//    private boolean coin = true;
//    private String answer;
//
//    ChoiceBall ballchoice = new ChoiceBall();
//    AnswerGenerator answerGenerate = new AnswerGenerator();
//
//    GameStart gameStart = new GameStart();
//    SelectCoin selectCoin = new SelectCoin();
//
//
//    public void abc(){
//        ballService.generateAnswer(3);
//    }
//    public BaseballGameController() {
//        while (coin) {
//            gameContinue();
//            gameEndView();
//            coin = getCoin();
//        }
//    }
//
////    public int ballsize() {
////        return getBall();
////    }
//
//   public void correctAnswer() {
//
//    }
//
//
//
//
//// ============================================================================
//
//    public String generateAnswer(int ballSize) {
//        return ballService.generateAnswer(ballSize);
//    }
//
//
//
//    public boolean matchNumber(int ballSize, String userNumber) {
//        // 예외
//        return ballService.matchNumber(ballSize, userNumber);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    ////////////////////
//    private void gameContinue() {
//        getBall();
//        makeAnswer();
//        startGame(answer, setBall);
//    }
//
////    private int getBall() {
////        InGameText.choiceBall();
////        setBall = ballchoice.getBall();
////        System.out.println(setBall);
////        return setBall;
////    }
//
//    private void makeAnswer() {
//        answerGenerate.getNumber(setBall);
//        answer = answerGenerate.getAnswer();
//        System.out.println(answer);
//    }
//
//    private void startGame(String answer, int setBall) {
//        gameStart.startGame(answer, setBall);
//    }
//
//    private void gameEndView() {
//        InGameText.correctAnswer(setBall);
//        InGameText.reGameText();
//    }
//
//    private boolean getCoin() {
//        coin = selectCoin.selectCoin();
//        return coin;
//    }
//
//
//}

    public int ballSize() {
        gameBallSize = viewService.choiceBall();
        return gameBallSize;
    }
    // 공 개수 정하기

    public void answerGenerator(int ballSize) {
        ballService.generateAnswer(gameBallSize);
    }
    // ballSize에 맞춰 정답 생성

    public String userNumber() {
        userNumber = viewService.userNumber();
        return userNumber;
    }
    // 사용자 정답 입력

    public void errorCheck(String userNumber) {
        InputValidator.onlyNumber(gameBallSize, userNumber);
        InputValidator.checkEachDiffNum(userNumber);
    }
    // 사용자 에러 체크(예외처리)

    public void ballCount(String userNumber) {
        ballService.ballCount(userNumber);
    }
    // 정답 & 유저 숫자 비교 후 볼카운트

    public void initBallCount() {
        ballService.initBallCount();
    }
    public int getStrike() {
        return ballService.getStrike();
    }
    // strike 개수

    public int getBall() {
        return ballService.getBall();
    }
    // ball 개수

    public int getNothing() {
        return ballService.getNothing();
    }
    // 노카운트 개수

    public void readCoin() {
        selectCoin.userCoin();
    }

    public int saveCoin() {
        return selectCoin.saveCoin();
    }
}





