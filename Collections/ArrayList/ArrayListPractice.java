
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class ArrayListPractice {
    public static void main(String[] args) {
        List<Integer> lst=new ArrayList<>();
        lst.add(12);
        lst.add(32);
        lst.add(21);
        lst.add(24);
        lst.add(28);
        lst.remove(Integer.valueOf(12));
          for(int a:lst){
            System.out.print(a+" ");
        }
        System.out.println();
        
        for(int a:lst){
            System.out.print(a+" ");
        }
        System.out.println();

        // arraylist to array
        Integer[] arr=new Integer[lst.size()];
        arr=lst.toArray(arr);
        for(Integer a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        Iterator<Integer> itr=lst.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println(itr.toString());


       
    }
}
