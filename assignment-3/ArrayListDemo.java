import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        
        System.out.println("ArrayList Constructors:");
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("1. Default constructor: " + list1);
        
        ArrayList<String> list2 = new ArrayList<>(20);
        System.out.println("2. Constructor with capacity: " + list2);
        
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("3. Constructor with collection: " + list3);
        
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println("\nArrayList Methods:");
        
        list.add("Java");
        System.out.println("1. add(): " + list);
        
        list.add(1, "Python");
        System.out.println("2. add(index, element): " + list);
        
        list.addAll(Arrays.asList("C++", "JavaScript"));
        System.out.println("3. addAll(): " + list);
        
        System.out.println("4. get(1): " + list.get(1));
        
        list.set(0, "Kotlin");
        System.out.println("5. set(0, 'Kotlin'): " + list);
        
        list.remove(1);
        System.out.println("6. remove(1): " + list);
        
        list.remove("C++");
        System.out.println("7. remove('C++'): " + list);
        
        System.out.println("8. size(): " + list.size());
        
        System.out.println("9. contains('Java'): " + list.contains("Java"));
        
        System.out.println("10. indexOf('JavaScript'): " + list.indexOf("JavaScript"));
        
        System.out.println("11. isEmpty(): " + list.isEmpty());
        
        ArrayList<String> subList = new ArrayList<>(list.subList(0, 2));
        System.out.println("12. subList(0, 2): " + subList);
        
        Object[] arr = list.toArray();
        System.out.println("13. toArray(): " + Arrays.toString(arr));
        
        list.clear();
        System.out.println("14. clear(): " + list);
        
        list.addAll(Arrays.asList("X", "Y", "Z"));
        list.removeAll(Arrays.asList("X", "Z"));
        System.out.println("15. removeAll(): " + list);
    }
}
