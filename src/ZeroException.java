public class ZeroException extends Exception{
    public ZeroException(String type){
        System.out.println(type + " 입력될 수 없습니다.");
    }
}
