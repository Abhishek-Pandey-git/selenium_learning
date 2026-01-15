import java.util.LinkedList;
import java.util.List;
public class LLPractice {
    

    public static void main(String[] args) {
        List<Integer> lst=new LinkedList<>();
        lst.add(12);
        lst.add(32);
        lst.add(21);
        lst.add(24);
        lst.add(28);
        lst.remove(Integer.valueOf(12));  // Remove VALUE 12, not index 12
        for(Integer a: lst){
            System.out.print(a + " ");
        }

        System.out.println();
        lst.addLast(100);
        lst.addFirst(200);

        for(Integer a: lst){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(lst.get(3));
       
    }


}
