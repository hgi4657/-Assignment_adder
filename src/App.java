import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 처음 시작할 때는 exit 값이 없어야 반복문이 시작하니까 초기값은 빈값
        String inputExit = "";

        // 길이가 10인 배열 선언 및 생성
        int[] intArray = new int[10];
        // 배열의 마지막 index 를 저장하는 변수
        int count = 0;

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

            // index 가 9일 경우, intArray 두번째 값부터 앞으로 당기기
            if (count == 9) {
                for (int i = 0; i < count; i++) { // index 8번 까지만
                    intArray[i] = intArray[i+1];
                }
                // 마지막 9번 index 에 값을 계속 넣기 위해서 ++count 삭제 / count 유지
                intArray[count] = result;
            } else {
                // 배열에 저장
                intArray[count] = result;
                // 배열 index 증가
                ++count;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            // 초기값 수정
            inputExit = sc.next();
        }
    }
}