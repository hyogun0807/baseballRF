package model;

public class InputValidator {
    private String userNumber;
    /**
     * Util -> 과연 이걸 메서드로 사용할 것인가, static으로 할것인가
     * <p>
     * 싱글톤을 사용해야한다.
     * 디자인패턴 : 이거는 정답이 아니다, 단지 하나의 방향성이고, 이걸 활용해서 사용하는거다 결국
     *
     * @param inputNum
     */

    public static void onlyNumber(int setBall, String userNumber) {
        if (userNumber.length() != setBall) {
            // Custom Exception 클래스를 만들 것인가
            // IllegalArugmentException을 사용할 것인가
            throw new IllegalArgumentException("[ERROR]: 3개의 값만 넣어햐 한다.");
        }
    }

    public static void checkEachDiffNum(String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            char currentDigit = userNumber.charAt(i);
            if (userNumber.indexOf(currentDigit, i + 1) != -1) {
                throw new IllegalArgumentException();
            }
        }
    }
}

/**
 * Exception
 * Validator
 */