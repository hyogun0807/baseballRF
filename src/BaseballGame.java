import controller.BaseballGameController;
import service.BaseballService;
import view.InGameText;
import view.OutputView;
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

    public BaseballGame(BaseballGameController baseballController, OutputView outputView, InputView inputView) {
        this.baseballController = baseballController;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        boolean coin = true;

        /**
         * Coin이 있을경우에만 동작을 한다.
         */
        while (coin) {
            // 매 동작마다 어떤 동작을 해야할까?
            // 숫자를 자동으로 생성 3자리

            // 게임 자리를 정하는 userInput
            String ballSize = readBaseballSize();
            baseballController.generateAnswer(ballSize);

            // 게임 시작
            startGame();

            gameContinue();
            gameEndView();
            coin = getCoin();
        }
    }

   private void startGame() {
       // 사용자의 input을 받는거지?
       String userNumber = readUserNUmber();
       boolean result = baseballController.matchNumber(userNumber);
   }

   private String readBaseballSize() {
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
