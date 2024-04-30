import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 처음 시작할 때는 exit 값이 없어야 반복문이 시작하니까 초기값은 빈값
        String inputExit = "";
        String inputRemove;
        String intQuiry;

        // 값을 추가하거나 삭제할 때 빠른 LinkedList 사용
        LinkedList<Integer> intLinkedList = new LinkedList<Integer>();

        int result = 0;
        // while 사용한 이유 => 반복이 진행될 정확한 범위가 존재하지 않기 때문
        while (!inputExit.equals("exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int SecondNum = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            // switch 사용한 이유 => for 문으로도 작성 가능하지만 가독성이 더 좋을 것 같아서
            switch (operator) {
                case '+':
                    result = firstNum + SecondNum;
                    break;
                case '-':
                    result = firstNum - SecondNum;
                    break;
                case '*':
                    result = firstNum * SecondNum;
                    break;
                case '/':
                    if (SecondNum == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = firstNum / SecondNum;
                    break;
            }
            System.out.println("결과: " + result);

            // 출력된 결과 추가
            intLinkedList.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            inputRemove = sc.next();

            // remove 를 입력 받았을 때 수행
            if (inputRemove.equals("remove")) {
                intLinkedList.remove(0);
                // intLinkedList.removeFirst();  // 이것도 같은 메서드인가?
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            intQuiry = sc.next();

            // inquiry 를 입력 받았을 때 수행
            if (intQuiry.equals("inquiry")) {
                for (int i : intLinkedList) {
                    System.out.print(i + " ");
                }
                System.out.println(); // 줄바꿈
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            // 초기값 수정
            inputExit = sc.next();
        }
    }
}