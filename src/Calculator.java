import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {

    // 생성자 추가 / 컬렉션 초기화
    public Calculator() {
        this.areaList = new ArrayList<>();
        this.numberList = new ArrayList<>();
    }

    // 배열 선언
    private ArrayList<Integer> numberList;
    private ArrayList<Double> areaList;
    // 정규식 검사용
    private static final String OPERATION_REG = "[+\\-*/]";
    // 원주율 저장 => static final : 공통적인 변하지 않는 불변의 값 (상수)
    private static final double PI = 3.14;

    // 원의 넓이를 계산하는 메서드
    public double calculateCircleArea(int radius) {
        double area = radius * radius * PI;
        areaList.add(area);
        return area;
    }
    public ArrayList<Double> getAreaList() {
        return areaList;
    }
    public void setAreaList(ArrayList<Double> areaList) {
        this.areaList = areaList;
    }
    public void inquiryAreas() {
        for (double i : areaList) {
            System.out.print(i + " ");
        }
        System.out.println(); // 줄바꿈
    }

    // 사칙연산 계산하는 메서드
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
    public void inquiryResults() {
        for (int i : numberList) {
            System.out.print(i + " ");
        }
        System.out.println(); // 줄바꿈
    }
}
