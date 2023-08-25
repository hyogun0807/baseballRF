import controller.BaseballGameController;
import service.BaseballService;
import view.OutputView;
import view.input.ScannerInput;


/**
 * Application을 실행시주는 역할
 */
public class BaseballApplication {

    public static void main(String[] args) {
        BaseballService baseballService = new BaseballService();
        BaseballGameController baseballGameController = new BaseballGameController(baseballService);

        OutputView outputView = new OutputView();

//        BaseballGame baseballGame1 = new BaseballGame(baseballGameController, outputView, new ConsoleInput());
//        BaseballGame baseballGame2 = new BaseballGame(baseballGameController, outputView, new FileInput());
        BaseballGame baseballGame3 = new BaseballGame(baseballGameController, outputView, new ScannerInput());

        baseballGame3.run();
    }
}