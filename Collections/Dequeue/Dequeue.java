// package Collections.Dequeue;
import java.util.Deque;
import java.util.ArrayDeque;
public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> num=new ArrayDeque<>();
        num.offer(1);
        num.offerFirst(2);
        num.offerLast(3);
        System.out.println(num);
        System.out.println(num.peekFirst());
        System.out.println(num.poll());
        System.out.println(num.pollLast());
        

    }
}
