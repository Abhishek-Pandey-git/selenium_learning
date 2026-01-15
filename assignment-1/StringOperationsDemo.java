import java.util.Scanner;

public class StringOperationsDemo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("String vs StringBuffer vs StringBuilder:");
        System.out.println("String: Immutable, thread-safe");
        System.out.println("StringBuffer: Mutable, thread-safe, synchronized");
        System.out.println("StringBuilder: Mutable, not thread-safe, faster\n");
        
        System.out.print("Enter a string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter another string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\nString Operations:");
        
        System.out.println("length(): " + str1.length());
        
        System.out.println("isEmpty(): " + str1.isEmpty());
        
        if(str1.length() > 0) {
            System.out.println("charAt(0): " + str1.charAt(0));
        }
        
        StringBuilder sb = new StringBuilder(str1);
        System.out.println("toString(): " + sb.toString());
        
        System.out.println("equals(): " + str1.equals(str2));
        
        System.out.println("compareTo(): " + str1.compareTo(str2));
        
        System.out.print("Enter substring to check: ");
        String sub = sc.nextLine();
        System.out.println("contains(): " + str1.contains(sub));
        
        System.out.println("indexOf('" + sub + "'): " + str1.indexOf(sub));
        
        System.out.println("lastIndexOf('" + sub + "'): " + str1.lastIndexOf(sub));
        
        System.out.println("startsWith('" + sub + "'): " + str1.startsWith(sub));
        
        System.out.println("endsWith('" + sub + "'): " + str1.endsWith(sub));
        
        System.out.print("Enter regex pattern: ");
        String regex = sc.nextLine();
        System.out.println("matches(): " + str1.matches(regex));
        
        if(str1.length() >= 3) {
            System.out.println("substring(0, 3): " + str1.substring(0, 3));
        }
        
        System.out.println("toLowerCase(): " + str1.toLowerCase());
        
        System.out.println("toUpperCase(): " + str1.toUpperCase());
        
        System.out.println("trim(): '" + str1.trim() + "'");
        
        System.out.print("Enter character to replace: ");
        char oldChar = sc.nextLine().charAt(0);
        System.out.print("Enter new character: ");
        char newChar = sc.nextLine().charAt(0);
        System.out.println("replace(): " + str1.replace(oldChar, newChar));
        
        System.out.println("split(' '): ");
        String[] words = str1.split(" ");
        for(String word : words) {
            System.out.println("  " + word);
        }
        
        System.out.println("join(): " + String.join("-", words));
        
        int num = 123;
        System.out.println("valueOf(123): " + String.valueOf(num));
        
        sc.close();
    }
}
