import controller.BaseballGameController;
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

            // 랜덤값 생성
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
            String userNumber = readUserNumber();
            // 숫자를 입력하세요 : 1234

            countStrikeAndBall(userNumber);
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

    private String readUserNumber() {
        String userNumber = baseballController.userNumber();
        validateUserInput(userNumber);
//
//        Number2 number = new Number2(randomGenerate);
//        Number2 UserInput = new Number2(userInput);
//       boolean a = number.match(userInput);
//
        return userNumber;
    }

    /**
     *  DTO는 데이터를 전송하기 위한 목적을 가지고 있다.
     *   - 데이터가 변경X
     *   - setter가 있으면 안된다.
     */
//    public static class NumberDto {
//        private int number;
//
//        public NumberDto(int number ) {
//            this.number = number;
//        }
//
//        public int getNumber() {
//            return number;
//        }
//    }

//    public static class Number2 {
//        private String number;
//
//        public Number2(String number) {
//            validate(number);
//            this.number = number;
//        }
//
//        /**
//         * 생성자에서 생성만 할 수 있어
//         *
//         * 객체 생성을 new가 아닌 의미있는 다른 메서드 명으로 할 수 있다.
//         * @param number
//         * @return
//         */
//        public static Number2 from(String number) {
//            validate(number);
//            return new Number2(number);
//        }
//
//        public boolean match(Number2 newNumber) {
//            return this.number.equals(newNumber.number);
//        }
//    }

    private void validateUserInput(String userNumber) {
        baseballController.errorCheck(userNumber);
    }

    private void countStrikeAndBall(String userNumber) {
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


