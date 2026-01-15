interface A{
    String methodA(String s);
}

interface B{
    int multiply(int x,int y);
}

public class Test2 {
    public static void main(String[] args) {
        A a=(String s) -> { return s+" hi"; };
        System.out.println(a.methodA("I say"));

        B b=(x,y)->{
            int z=x*y;
           return z;
        };

        System.out.println(b.multiply(20,30));



    }
}
