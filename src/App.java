import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 인스턴스 생성
        Calculator calc = new Calculator();


        // 초기값 설정 & 변수 선언
        String inputExit = "";
        String inputRemove;
        String intQuiry;
        int result;

        try {
            while (!inputExit.equals("exit")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int firstNum = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNum = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                result = calc.calculate(operator,firstNum,secondNum);
                System.out.println("결과: " + result);

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                inputRemove = sc.next();

                // remove 를 입력 받았을 때 수행
                if (inputRemove.equals("remove")) {
                    calc.delList();
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                intQuiry = sc.next();

                // inquiry 를 입력 받았을 때 수행
                if (intQuiry.equals("inquiry")) {
                    for (int i : calc.getList()) {
                        System.out.print(i + " ");
                    }
                    System.out.println(); // 줄바꿈
                }

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                // 초기값 수정
                inputExit = sc.next();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}