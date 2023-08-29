package view;

public class InGameText {
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
