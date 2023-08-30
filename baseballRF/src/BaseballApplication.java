import controller.BaseballGameController;
import service.BaseballService;
import service.ViewService;
import view.OutputView;
import view.input.ScannerInput;


/**
 * Application을 실행시주는 역할
 */
public class BaseballApplication {

    /**
     * 싱글톤 패턴
     * @param args
     */

    public static void main(String[] args) {
        BaseballService baseballService = new BaseballService();
        ViewService viewService = new ViewService();

        BaseballGameController baseballGameController = new BaseballGameController(baseballService, viewService);

        OutputView outputView = new OutputView();

        BaseballGame baseballGame = new BaseballGame(baseballGameController, outputView, new ScannerInput());

        baseballGame.run();
    }
}