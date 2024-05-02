import java.util.ArrayList;

// 자식클래스
// 원과 관련된 연산을 수행하는 계산기
public class CircleCalculator extends Calculator {
    // 생성자
    public CircleCalculator(ArrayList<Double> numberList) {
        super(numberList);
    }

    // 원주율
    public static final double PI = 3.14;

    // 원의 넓이를 계산하는 메서드
    public double calculate(int radius) {
        return radius * radius * PI;
    }

    // 원주율 조회 메서드 (비슷한 기능, 재정의)
    @Override
    void inquiryResult() {
        getNumberList().forEach(result -> System.out.print(result + " "));
        System.out.println(); // 줄바꿈
    }
}
