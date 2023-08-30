import java.util.List;

public class Test {

    public static void main(String[] args) {
        Animal animal1 = new Animal(1,"개", "멍멍");
        Animal animal2 = new Animal(10,"고양이", "야홍");
        Animal animal3 = new Animal(2,"사자", "어흥");
        Animal animal4 = new Animal(71,"호랑이", "으르렁");
        // [["개", "멍멍"], ["고양이", "야옹"] .....]

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4);

        Animal animal = new Dog(1,"개", "멍멍");
        Dog dog = new Dog(1,"개", "멍멍");


//        Depense cb = new CB();
//        cb.depense();
//
//        cb.kickBall();
//        cb.pass();
    }
}


/**
 * 상속 구현
 * extends, implements
 * 
 * public -> 외부에서 접근이 가능하고 마음대로 변경이 가능해
 * 
 * 우리는 동물원, 이 동물원에서 여러 동물을 키워
 * 개 1, 개, 멍멍
 * 고양이 10, 고양이, 야옹
 * 사자 2, 사자, 어흥
 * 호랑이 7, 호랑이, 으르렁
 *
 * 상황: 동물들의 울음소리를 듣고 싶다. 녹음을 하려면 출력을 해야해
 *
 * 결과
 *  이름: 멍멍
 *  개: 멍멍
 *  고양이: 야옹
 *  사자: 어흥
 *  호랑이: 으르렁
 *
 *
 *  새로운 상황
 *  개는 불알이 3개
 *
 *  고양이: 목숨이 2개, 불알이 없어
 *
 *
 *  공통된 상태를 가지고 있는거야 근데 다른 상태도 있어, 다른 행동이 있어도
 *   -> 상속을 할 수가 있다.
 *
 *   추상클래스, 인터페이스, 상속 <=
 */

class Animal {

    private int age;
    private String name;
    private String bark;

    private String fireEgg;

    public Animal(int age, String name, String bark) {
        this.age = age;
        this.name = name;
        this.bark = bark;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBark() {
        return bark;
    }

    public void bark() {
        System.out.println(bark);
    }

    private void addAge() {
        age++;
    }

    protected void resetName() {
        name = " 초기화";
    }

    @Override
    public String toString() {
        return "Aniaml{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", bark='" + bark + '\'' +
                '}';
    }
}

class Dog extends Animal {
    public int dog;

    public Dog(int age, String name, String bark) {
        super(age, name, bark);
    }

    public void resetName() {
        super.resetName();
    }

    public int getDog() {
        return dog;
    }
}

/**
 * 왜 추상 클래스가 존재하야할까?
 *  - 추상
 *
 * 메서드 ㄴ는 행동을 나타내고, 객체는 행동을 먼저 정해ㅐ야한다.
 * 행동에 따라 상태가 달라진다.
 *
 *  인터페이스
 *   - 공통된 행동을 관리하기 위해서 사용한다.
 *   - 나는 어떻게 행동하는지는 중요하지가 않다. 행동만 해라 결과만 나타내라 너가 알아서 잘하겠지
 *   - 너가 알아서 잘하겠지 = 객체가 자신의 책임을 다한다.
 *   - 그러면 의존성이 사라진다.
 *
 */
//interface Depense {
//
//    void kickBall();
//
//    void pass();
//
//    void depense();
//}
//
//interface ATTACK {
//    void shoot();
//
//    void 코너킥();
//
//    void 프리킥();
//}
//
//class CB implements Depense {
//
//    private void db() {
//
//    }
//
//    @Override
//    public void kickBall() {
//        db();
//    }
//
//    @Override
//    public void pass() {
//        옆으로 패스한다.
//    }
//
//    @Override
//    public void depense() {
//        몸으로 밀친다.
//    }
//}
//
//class MF implements Depense, ATTACK {
//
//    @Override
//    public void kickBall() {
//        빈틈으로 보낸다.
//    }
//
//    @Override
//    public void pass() {
//        수비로 보낸다.
//    }
//
//    @Override
//    public void depense() {
//
//    }
//
//    @Override
//    public void shoot() {
//
//    }
//
//    @Override
//    public void 코너킥() {
//
//    }
//
//    @Override
//    public void 프리킥() {
//
//    }
//}

//class FW implements ATTACK {
//    private int age;
//    public void tesT() {}
//    @Override
//    public void shoot() {
//
//    }
//
//    @Override
//    public void 코너킥() {
//
//    }
//
//    @Override
//    public void 프리킥() {
//
//    }
//}


/**
 * 일반 클래스의 상속는
 *  - 공통된 상태와 행동을 미리 지정할 수 있다.
 *  - 마음에 안들면 너가 바꿔 = override
 *  - 자식클래스는 부모클래스의 모든 것을 사용할 수 있어 (필드변수(상태)와ㅏ 메서드 (행동)_)
 *  - 해도 되고 안해도 되고
 *
 *  - 자식이 무조건 부모의 정보를 알아야해 = 부모가 바뀌면 자식은 무조건 바뀌어야해
 *  - 의존성이 강해
 *
 * 인터페이스
 *  - 공통된 행동을 정의하는겅야
 *  - 공통된 행동을 우리는 사용만 할게 알아서 정의해
 *  - 각각의 멧더를 정의할 수있다.
 */

/**
 * 추상클래스
 *  - 공통된 상태와 행동이 있는데
 *  - 어떤 값은 무조건 사용했으묘ㅕㄴ 좋겠어
 *  - 행동을 강제
 */
//abstract class Par {
//    int age;
//    String name;
//
//    public void walk() {
//        if (내가 물속에 있으면) {
//            swim();
//        }
//
//    }
//
//    public abstract void swim();
//}
//
//class Chi extends Par{
//    int legCount;
//
//
//    @Override
//    public void swim() {
//        나는 배영을 한다.
//    }
//}

// 자바 7

// default
//interface Test2 {
//    default void test() {
//
//    }
//}

