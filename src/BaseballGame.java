import controller.BaseballGameController;

public class BaseballGame {

    public void run() {
        BaseballGameController baseballController = new BaseballGameController();
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
}
