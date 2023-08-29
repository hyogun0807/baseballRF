package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// 랜덤인 3자리의 수 만들기(문제의 정답)
public class AnswerGenerator {
    private List<Integer> answerList;
    // 객체지향의 3 요소 : 다형성, 상속, 캡슐화
    // 5 principle : solid
    private Random random = new Random();
    private String answer;

    /**
     * Magic Number -> static 변수 or ENUM으로 관리를 해준다.
     * static : 메인 코드를 알기 힘들다.
     *   - 해당 클래스에서만 사용할때
     *
     *  Enum : 다양하게 사용 가능하다.
     */
    private void makeNumber(int ball) {
        while (answerList.size() < ball) {
            int num = random.nextInt(9) + 1;
            if (!answerList.contains(num)) {
                answerList.add(num);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Object num : answerList) {
            result.append(num);
        }
        answer = result.toString();
    }

    public String makeAnswer(int ball){
        answerList = new ArrayList<>();
        makeNumber(ball);
        return getAnswer();
    }

    public String getAnswer() {
        return answer;
    }

    public void getNumber(int ball) {
        answerList = new ArrayList<>();
        makeNumber(ball);
    }
}