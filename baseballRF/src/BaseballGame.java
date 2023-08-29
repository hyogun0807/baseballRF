import controller.BaseballGameController;
import model.InputValidator;
import service.BaseballService;
import view.*;
import view.input.InputView;

/**
 * BaseballGame : 게임 동작
 *
 *  - BaseballController => 뷰단과 모델을 연결, 즉 데이터의 전송에대허서만 역할을 가진다.
 *      뷰에서 데이터를 읽어오면 그 값을 받아서 서비스에 전달해준다.
 */
public class BaseballGame {

    private BaseballGameController baseballController;
    private OutputView outputView;
    private InputView inputView;

    private String userNumber;
    private int ballSize;
    private int strike;
    private int ball;
    private int nothing;


    public BaseballGame(BaseballGameController baseballController, OutputView outputView, InputView inputView) {
        this.baseballController = baseballController;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        boolean gameCoin = true;
        while (gameCoin) {
            boolean notOut = true;
            inputBallSize();
            generateAnswer();
            playBaseBallGame(notOut);

            readCoin();
            gameCoin = initGameCoin();
        }
    }

    private void playBaseBallGame(boolean notOut) {
        while (notOut) {
            initGameCondition();
            inputUserNumber();
            // 숫자를 입력하세요 : 1234

            countStrikeAndBall();
            // 볼카운트 세기
            showBallCount();
            gameEndTextView();
            notOut = strikeOut();
        }
    }
    private void inputBallSize() {
        ballSize = baseballController.ballSize();
    }

    private void generateAnswer() {
        baseballController.answerGenerator(ballSize);
    }

    private void inputUserNumber() {
        userNumber = baseballController.userNumber();
        validateUserInput();
    }

    private void validateUserInput() {
        baseballController.errorCheck(userNumber);
    }

    private void countStrikeAndBall() {
        baseballController.ballCount(userNumber);
    }

    private void saveBallCount() {
        strike = baseballController.getStrike();
        ball = baseballController.getBall();
        nothing = baseballController.getNothing();
    }

    private void showBallCount() {
        saveBallCount();
        outputView.ballCountView(strike, ball, nothing, ballSize);
    }

    private boolean strikeOut() {
        return strike != ballSize;
    }

    private void gameEndTextView() {
        InGameText.correctAnswer(ballSize);
    }
    private void readCoin() {
        InGameText.reGameText();
        baseballController.readCoin();
    }

    private boolean initGameCoin() {
        return baseballController.saveCoin() == 1;
    }

    private void initGameCondition() {
        baseballController.initBallCount();
    }
}
//}

//        boolean coin = true;
//        String answer;
//        int ballSize;
//        /**
//         * Coin이 있을경우에만 동작을 한다.
//         */
//
//        while (coin) {
//            // 매 동작마다 어떤 동작을 해야할까?
//            // 숫자를 자동으로 생성 3자리
//
//            // 게임 자리를 정하는 userInput
//            ballSize = readBaseballSize();
//
////            baseballController.generateAnswer(ballSize);
//            // 정답 생성
//            answer = makeAnswer(ballSize);
//            System.out.println(answer);
//
//            // 게임 시작
//            startBaseballGame(ballSize);
//            coin = false;
////
////            gameContinue();
////            gameEndView();
////            coin = getCoin();
//        }
//    }
//
//// ===========================================================
//
//    private int baseaseballSize() {
//        InGameText.choiceBall();
//        return choiceBallSize.getBall();
//
//    }
//
//    private String makeAnswer(int ballSize) {
//        return baseballController.generateAnswer(ballSize);
//    }
//
//    private String userInput() {
//        return ""
//    }
//
//   private void startBaseballGame(int ballSize) {
//       boolean notAllStrike = true;
//       String userInput;
//
//       while (notAllStrike) {
//           // 사용자 정답 입력
//           userInput = inputNumber.getNumber();
//           // 정답 확인
//           errorCheck(ballSize, userInput);
//           baseballController.matchNumber(ballSize,userInput);
//       }
//   }
//
//   private void correctAnswer(){
//
//   }
//
//
//
//
//
//   private String readUserAnswer() {
//        InGameText.inputNumber();
//        return inputNumber.getNumber();
//   }
//
//   private void errorCheck(int ballSize, String userNumber) {
//       InputValidator.checkEachDiffNum(userNumber);
//       InputValidator.onlyNumber(ballSize, userNumber);
//   }
//
//
//
//    private void gameContinue() {
//        getBall();
//        makeAnswer();
//        startGame(answer, setBall);
//    }
//
////    private void getBall() {
////        InGameText.choiceBall();
////        setBall = ballchoice.getBall();
////        System.out.println(setBall);
////    }
//
//
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


