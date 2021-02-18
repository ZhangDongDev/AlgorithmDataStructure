public class Test01 {
    public static void main(String[] args) {
        int a = 1;
        int b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("Swap ------");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
