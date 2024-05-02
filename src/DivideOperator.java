// 나누기를 수행하는 (몫)
public class DivideOperator implements Operator {
    // 값이 들어올 때는 int 로 받아오고 있다
    @Override
    public int operate(int num1, int num2) {
        return num1 / num2;
    }
}
