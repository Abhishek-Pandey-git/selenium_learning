import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        
        System.out.println("Vector Constructors:");
        Vector<Integer> v1 = new Vector<>();
        System.out.println("1. Default constructor: " + v1);
        
        Vector<Integer> v2 = new Vector<>(10);
        System.out.println("2. Constructor with capacity: " + v2);
        
        Vector<Integer> v3 = new Vector<>(10, 5);
        System.out.println("3. Constructor with capacity and increment: " + v3);
        
        Vector<Integer> v4 = new Vector<>(Arrays.asList(1, 2, 3));
        System.out.println("4. Constructor with collection: " + v4);
        
        Vector<Integer> v = new Vector<>();
        
        System.out.println("\nVector Methods:");
        
        v.add(10);
        v.add(20);
        v.add(30);
        System.out.println("1. add(): " + v);
        
        v.add(1, 15);
        System.out.println("2. add(index, element): " + v);
        
        v.addElement(40);
        System.out.println("3. addElement(): " + v);
        
        System.out.println("4. get(2): " + v.get(2));
        
        System.out.println("5. firstElement(): " + v.firstElement());
        
        System.out.println("6. lastElement(): " + v.lastElement());
        
        v.set(0, 5);
        System.out.println("7. set(0, 5): " + v);
        
        v.remove(1);
        System.out.println("8. remove(1): " + v);
        
        v.removeElement(40);
        System.out.println("9. removeElement(40): " + v);
        
        System.out.println("10. size(): " + v.size());
        
        System.out.println("11. capacity(): " + v.capacity());
        
        System.out.println("12. contains(20): " + v.contains(20));
        
        System.out.println("13. indexOf(30): " + v.indexOf(30));
        
        System.out.println("14. isEmpty(): " + v.isEmpty());
        
        v.clear();
        System.out.println("15. clear(): " + v);
    }
}
