// 나누기를 수행하는 (나머지)
public class ModOperator implements Operator {
    // 값이 들어올 때는 int 로 받아오고 있다
    // 예외처리 추가
    @Override
    public int operate(int num1, int num2) throws ZeroException{
        if (num2 == 0) {
            throw new ZeroException("두번째 값에 0 은");
        }
        return num1 % num2;
    }
}
