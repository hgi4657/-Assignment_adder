import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
        this.numberList = new ArrayList<>();
    }

    // 배열 선언
    private ArrayList<Integer> numberList;
    // 정규식 검사용
    private static final String OPERATION_REG = "[+\\-*/]";

    public int calculate(char operator, int firstNumber, int secondNumber) throws Exception {
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
    public ArrayList<Integer> getList() {
        return numberList;
    }
    public void setList(ArrayList<Integer> numberList) {
        this.numberList = numberList;
    }
    public void removeResult() {
        numberList.remove(0);
    }
}
