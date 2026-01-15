
interface A{
    void methodA();
}
public class Test {
    public static void main(String[] args) {
        A a=()->{
            System.out.println("Hello from methodA");
            int b=22;
            System.out.println("Value of b: "+b);
        };
        a.methodA();
    }
}
