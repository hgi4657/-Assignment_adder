import java.util.LinkedHashSet;
import java.util.regex.Pattern;

public class Calculator {

    // 배열 생성
    LinkedHashSet<Integer> numberList = new LinkedHashSet<Integer>();
    // 정규식 검사용
    private static final String OPERATION_REG = "[+\\-*/]";

    public int getFirstNumber(char operator, int firstNumber, int secondNumber) throws Exception {
        // 오류 검사 (사칙연산, 두번째 숫자 0)
        if (!Pattern.matches(OPERATION_REG, String.valueOf(operator))) {
            throw new ZeroException("사칙연산 외");
        }
        if (secondNumber == 0) {
            throw new ZeroException("두번째 숫자에 0은");
        }
        int answer = 0;
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
        numberList.add(answer);
        return answer;
    }


}
