package view;

// ENUM
public class InGameText {

    public static final String NO_ACCEPT = "접근하면 안됨";

    private InGameText() {
        throw new RuntimeException("접근하면 안됨");
    }

    public static void choiceBall() {
        System.out.print("게임에 진행 할 숫자 개수를 정해주세요. : ");
    }

    public static void inputNumber() {
        System.out.print("숫자를 입력하세요. : ");
    }

    public static void correctAnswer(int setBall) {
        System.out.println(setBall + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void reGameText() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
    }
}

/**
 * JVM
 *
 * InGameText 컴파일
 *
 * class -> 로드
 *
 * Constant Pool : 상수들을 저장해서 사용하는 그런 pool
 *
 * 각 클래스마다 상수풀을 가지고있어,
 *
 * InGameText ->
 *   - Constant Pool
 *       - 주소1 (접근하면 안됨)
 *       - 주소2
 */


//enum InGame {
//    CHOICE_BALL_TEXT("게임에 진행 할 숫자 개수를 정해주세요. : ")
//
//    private String message;
//
//    InGame(String message) {
//        this.message = message;
//    }
//}
