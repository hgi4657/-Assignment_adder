import java.util.ArrayList;

// 자식클래스
// 원과 관련된 연산을 수행하는 계산기
public class CircleCalculator extends Calculator {
    // 생성자
    public CircleCalculator(ArrayList<Double> numberList) {
        super(numberList);
    }

    // 원의 넓이를 계산하는 메서드
    public double calculate(int radius) {
        double area = radius * radius * PI;
        super.getNumberList().add(area);
        return area;
    }

    // 원주율 조회 메서드 (비슷한 기능, 재정의)
    @Override
    void inquiryResult() {
        for (double i : super.getNumberList()) {
            System.out.print(i + " ");
        }
        System.out.println(); // 줄바꿈
    }
}
