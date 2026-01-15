import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        
        System.out.println("HashMap Constructors:");
        HashMap<String, Integer> map1 = new HashMap<>();
        System.out.println("1. Default constructor: " + map1);
        
        HashMap<String, Integer> map2 = new HashMap<>(20);
        System.out.println("2. Constructor with capacity: " + map2);
        
        HashMap<String, Integer> map3 = new HashMap<>(20, 0.75f);
        System.out.println("3. Constructor with capacity and load factor: " + map3);
        
        HashMap<String, Integer> tempMap = new HashMap<>();
        tempMap.put("A", 1);
        HashMap<String, Integer> map4 = new HashMap<>(tempMap);
        System.out.println("4. Constructor with map: " + map4);
        
        HashMap<String, Integer> map = new HashMap<>();
        
        System.out.println("\nHashMap Methods:");
        
        map.put("John", 25);
        map.put("Alice", 30);
        map.put("Bob", 28);
        System.out.println("1. put(): " + map);
        
        System.out.println("2. get('John'): " + map.get("John"));
        
        map.putIfAbsent("Charlie", 35);
        System.out.println("3. putIfAbsent(): " + map);
        
        map.remove("Bob");
        System.out.println("4. remove('Bob'): " + map);
        
        System.out.println("5. containsKey('Alice'): " + map.containsKey("Alice"));
        
        System.out.println("6. containsValue(25): " + map.containsValue(25));
        
        System.out.println("7. size(): " + map.size());
        
        System.out.println("8. isEmpty(): " + map.isEmpty());
        
        System.out.println("9. keySet(): " + map.keySet());
        
        System.out.println("10. values(): " + map.values());
        
        System.out.println("11. entrySet(): " + map.entrySet());
        
        map.replace("John", 26);
        System.out.println("12. replace('John', 26): " + map);
        
        System.out.println("13. getOrDefault('David', 0): " + map.getOrDefault("David", 0));
        
        HashMap<String, Integer> map5 = new HashMap<>();
        map5.put("Eve", 22);
        map.putAll(map5);
        System.out.println("14. putAll(): " + map);
        
        map.clear();
        System.out.println("15. clear(): " + map);
    }
}
