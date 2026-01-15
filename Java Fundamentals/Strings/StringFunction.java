public class StringFunction {
    public static void main(String[] args) {
        // String str="Abhishek";
        // String str1="Pandey", str2="abhishek";
        

        // System.out.println("Length of the string is: "+str.length());
        // System.out.println(str.toLowerCase());
        // System.out.println(str);
        // System.out.println(str.toUpperCase());
        // System.out.println(str.charAt(3));
        // System.out.println(str.equals(str1));
        // System.out.println(str.equalsIgnoreCase(str2));
        // System.out.println(str.startsWith("Abhi"));
        // System.out.println(str1.endsWith("ez"));
        // System.out.println(str.indexOf("s"));
        // System.out.println(str.lastIndexOf("h"));
        // System.out.println(str.substring(2, 6));
        // System.out.println(str.concat(" Pandey"));
        // System.out.println(str.trim());
        
        StringBuffer s=new StringBuffer("Hello");
        System.out.println(s.capacity());
        System.out.println(s.length());
        System.out.println(s.append(" Brother"));
        System.out.println(s);
        System.out.println(s.insert(1, "khfoere"));
        System.out.println(s.reverse());
        System.out.println(s);
        System.out.println(s.delete(3, 7));
        System.out.println(s.deleteCharAt(3));
       System.out.println(s);

    }
    
}
