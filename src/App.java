import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 인스턴스 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(new ArrayList<>());
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayList<>());

        // 초기값 설정 & 변수 선언
        String inputExit = "";
        String inputRemove;
        String intQuiry;
        double result;

        try {
            System.out.println("사칙연산을 계산하고 싶다면 '1'을 입력하고, 원의 넓이를 구하고 싶다면 '2'를 입력하세요");
            String goForOperatorCircle = sc.nextLine();

            // 1 을 받았을 경우 (사칙연산)
            if (goForOperatorCircle.equals("1")) {
                while (!inputExit.equals("exit")) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int firstNum = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int secondNum = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);

                    // 사칙연산 계산
                    result = arithmeticCalculator.calculate(operator,firstNum,secondNum);
                    System.out.println("결과: " + result);
                    // 저장 메서드 추가
                    arithmeticCalculator.addResult(result);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    inputRemove = sc.next();

                    // remove 를 입력 받았을 때 첫번째 index 값 삭제
                    if (inputRemove.equals("remove")) {
                        arithmeticCalculator.removeResult();
                    }

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    intQuiry = sc.next();

                    // inquiry 를 입력 받았을 때 전체 조회
                    if (intQuiry.equals("inquiry")) {
                        arithmeticCalculator.inquiryResult();
                    }

                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    // 초기값 수정
                    inputExit = sc.next();
                }
            // 2 를 받았을 경우 (원의 넓이)
            } else if (goForOperatorCircle.equals("2")) {
                while (!inputExit.equals("exit")) {
                    System.out.print("원의 반지름을 입력하세요: ");
                    int circleRadius = sc.nextInt();

                    // 계산된 원의 넓이
                    result = circleCalculator.calculate(circleRadius);
                    System.out.println("결과: " + result);
                    // 결과값 저장 메서드
                    circleCalculator.addResult(result);

                    // 저장된 원의 넓이 값들 전체 조회
                    circleCalculator.inquiryResult();

                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    inputExit = sc.next();
                }
            } else {
                // 숫자가 잘못 입력되었을 때
                System.out.println("해당 숫자는 계산식이 존재하지 않습니다");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}