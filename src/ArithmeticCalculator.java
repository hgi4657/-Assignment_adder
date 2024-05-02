import java.util.ArrayList;
import java.util.regex.Pattern;

// 자식 클래스
// 사칙연산을 수행하는 계산기
public class ArithmeticCalculator extends Calculator {
    // 생성자
    public ArithmeticCalculator(ArrayList<Double> numberList) {
        super(numberList);
    }

    // 정규식 검사용
    private static final String OPERATION_REG = "[+\\-*/]";

    // 사칙연산 계산하는 메서드
    public double calculate(char operator, int firstNumber, int secondNumber) throws Exception {
        // 오류 검사 (사칙연산, 두번째 숫자 0)
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new ZeroException("사칙연산 외");
        }
        if (secondNumber == 0) {
            throw new ZeroException("두번째 숫자에 0은");
        }
        double answer = 0;
        switch(operator) {
            case '+': answer = firstNumber + secondNumber;
                break;
            case '-': answer = firstNumber - secondNumber;
                break;
            case '*': answer = firstNumber * secondNumber;
                break;
            case '/': answer = firstNumber / secondNumber;
                break;
        }
        super.getNumberList().add(answer);
        return answer;
    }

    // 사칙연산 조회 메서드 (비슷한 기능, 재정의)
    @Override
    void inquiryResult() {
        // 부모의 컬렉션 get
        for (double i : super.getNumberList()) {
            System.out.print(i + " ");
        }
        System.out.println(); // 줄바꿈
    }
}
