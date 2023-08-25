import controller.BaseballGameController;


/**
 * Application을 실행시주는 역할
 */
public class BaseballApplication {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();
    }
}