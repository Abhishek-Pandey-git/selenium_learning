class TestGen<T>{
    public T sums(T a){
        return a;
    } 
}
public class Generic {
    
   public static void main(String[] args) {
     TestGen<Integer> t=new TestGen<Integer>();
     Integer a=20;
     System.out.println(t.sums(a));
   }
}
