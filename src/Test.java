public class Test {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            System.out.println(calc.getFirstNumber('1',2,2));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
