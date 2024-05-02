import java.util.ArrayList;

// 추상 클래스
public abstract class Calculator {

    // 생성자 추가 / 컬렉션 초기화
    // 여기 () 안에 (ArrayList<Double> numberList 를 넣어야 하는 이유 ?
    // 여태 안 넣어도 괜찮았는데 추상 클래스 / 메서드 반영 후 안됨 !
    public Calculator(ArrayList<Double> numberList) {
        this.numberList = numberList;
    }

    // 배열 선언
    private final ArrayList<Double> numberList;

    // Getter
    public ArrayList<Double> getNumberList() {
        return numberList;
    }

    // 삭제 메서드
    public void removeResult() {
        numberList.remove(0);
    }

    // 저장 메서드
    public void addResult(double result) {
        numberList.add(result);
    }

    // 값을 조회하는 추상 메서드
    abstract void inquiryResult();
    // calculate 는 추상 메서드로 사용하지 않는 이유
    // 매개변수가 달라서 하나 부를 때 두가지 전부를 불러와야 해서
    // 필요없는 메서드도 같이 가져오게 됨 (사용 시 주의)
}
