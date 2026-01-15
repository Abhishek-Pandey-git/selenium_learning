import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        
        System.out.println("TreeMap Constructors:");
        TreeMap<String, Integer> tm1 = new TreeMap<>();
        System.out.println("1. Default constructor: " + tm1);
        
        TreeMap<String, Integer> tm2 = new TreeMap<>(Comparator.reverseOrder());
        System.out.println("2. Constructor with comparator: " + tm2);
        
        TreeMap<String, Integer> tempTm = new TreeMap<>();
        tempTm.put("A", 1);
        TreeMap<String, Integer> tm3 = new TreeMap<>(tempTm);
        System.out.println("3. Constructor with map: " + tm3);
        
        SortedMap<String, Integer> sm = new TreeMap<>();
        sm.put("B", 2);
        TreeMap<String, Integer> tm4 = new TreeMap<>(sm);
        System.out.println("4. Constructor with sorted map: " + tm4);
        
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        System.out.println("\nTreeMap Methods:");
        
        tm.put("Dog", 4);
        tm.put("Cat", 2);
        tm.put("Elephant", 8);
        tm.put("Bird", 1);
        System.out.println("1. put() - sorted: " + tm);
        
        System.out.println("2. get('Cat'): " + tm.get("Cat"));
        
        tm.putIfAbsent("Fish", 3);
        System.out.println("3. putIfAbsent(): " + tm);
        
        tm.remove("Bird");
        System.out.println("4. remove('Bird'): " + tm);
        
        System.out.println("5. containsKey('Dog'): " + tm.containsKey("Dog"));
        
        System.out.println("6. containsValue(8): " + tm.containsValue(8));
        
        System.out.println("7. size(): " + tm.size());
        
        System.out.println("8. firstKey(): " + tm.firstKey());
        
        System.out.println("9. lastKey(): " + tm.lastKey());
        
        System.out.println("10. firstEntry(): " + tm.firstEntry());
        
        System.out.println("11. lastEntry(): " + tm.lastEntry());
        
        System.out.println("12. headMap('Dog'): " + tm.headMap("Dog"));
        
        System.out.println("13. tailMap('Dog'): " + tm.tailMap("Dog"));
        
        System.out.println("14. subMap('Cat', 'Fish'): " + tm.subMap("Cat", "Fish"));
        
        tm.clear();
        System.out.println("15. clear(): " + tm);
    }
}
