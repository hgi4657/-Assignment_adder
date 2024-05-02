import java.util.ArrayList;

// 자식 클래스
// 사칙연산을 수행하는 계산기
public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(ArrayList<Double> numberList) {
        super(numberList);
    }
    
    public double calculate(char operation, int num1, int num2) throws ZeroException {
        return operatorFactory(operation).operate(num1, num2);
    }

    // 연산자를 선택해주는 기능 (클래스로 만드는것이 더 좋음)
    // new 가 계속 생겨나서 메모리 측면에서 좋지 않음
    // 예외 처리 추가
    private Operator operatorFactory(char operator) throws ZeroException {
        // 요즘 새로 쓰는 switch 형태, break 자동으로 해줌
        return switch (operator) {
            case '+' -> new AddOperator();
            case '-' -> new SubtractOperator();
            case '*' -> new MultiplyOperator();
            case '/' -> new DivideOperator();
            case '%' -> new ModOperator();
            default -> throw new ZeroException("사칙연산 외 다른 것은 ");
        };
    }

    // 사칙연산 조회 메서드 (비슷한 기능, 재정의)
    @Override
    void inquiryResult() {
        getNumberList().forEach(result -> System.out.print(result + " "));
    }
}
