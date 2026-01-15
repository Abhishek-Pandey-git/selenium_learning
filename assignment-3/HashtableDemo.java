import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        
        System.out.println("Hashtable Constructors:");
        Hashtable<String, Integer> ht1 = new Hashtable<>();
        System.out.println("1. Default constructor: " + ht1);
        
        Hashtable<String, Integer> ht2 = new Hashtable<>(20);
        System.out.println("2. Constructor with capacity: " + ht2);
        
        Hashtable<String, Integer> ht3 = new Hashtable<>(20, 0.75f);
        System.out.println("3. Constructor with capacity and load factor: " + ht3);
        
        Hashtable<String, Integer> tempHt = new Hashtable<>();
        tempHt.put("A", 1);
        Hashtable<String, Integer> ht4 = new Hashtable<>(tempHt);
        System.out.println("4. Constructor with map: " + ht4);
        
        Hashtable<String, Integer> ht = new Hashtable<>();
        
        System.out.println("\nHashtable Methods:");
        
        ht.put("Apple", 100);
        ht.put("Banana", 150);
        ht.put("Orange", 120);
        System.out.println("1. put(): " + ht);
        
        System.out.println("2. get('Apple'): " + ht.get("Apple"));
        
        ht.putIfAbsent("Mango", 80);
        System.out.println("3. putIfAbsent(): " + ht);
        
        ht.remove("Banana");
        System.out.println("4. remove('Banana'): " + ht);
        
        System.out.println("5. containsKey('Orange'): " + ht.containsKey("Orange"));
        
        System.out.println("6. containsValue(100): " + ht.containsValue(100));
        
        System.out.println("7. contains(120): " + ht.contains(120));
        
        System.out.println("8. size(): " + ht.size());
        
        System.out.println("9. isEmpty(): " + ht.isEmpty());
        
        System.out.println("10. keys(): " + ht.keys());
        
        System.out.println("11. elements(): " + ht.elements());
        
        System.out.println("12. keySet(): " + ht.keySet());
        
        System.out.println("13. values(): " + ht.values());
        
        ht.replace("Apple", 110);
        System.out.println("14. replace('Apple', 110): " + ht);
        
        ht.clear();
        System.out.println("15. clear(): " + ht);
    }
}
