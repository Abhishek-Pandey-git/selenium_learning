// package Collections.Queue;

import java.util.Queue;
import java.util.LinkedList;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(23);
        q.add(22);
        q.add(24);
        q.remove(22);
        System.out.println(q);
        System.out.println(q.size());
    }
}
