import java.util.Scanner;

public class ArrayOperations {
    
    int[] arr;
    int size;
    
    public void createArray(Scanner sc) {
        System.out.print("Enter array size: ");
        size = sc.nextInt();
        arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    }
    
    public void insert(Scanner sc) {
        System.out.print("Enter position (0 to " + size + "): ");
        int pos = sc.nextInt();
        System.out.print("Enter value: ");
        int val = sc.nextInt();
        
        int[] newArr = new int[size + 1];
        for(int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = val;
        for(int i = pos; i < size; i++) {
            newArr[i + 1] = arr[i];
        }
        arr = newArr;
        size++;
        System.out.println("Element inserted successfully");
    }
    
    public void delete(Scanner sc) {
        System.out.print("Enter position (0 to " + (size-1) + "): ");
        int pos = sc.nextInt();
        
        int[] newArr = new int[size - 1];
        for(int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        for(int i = pos + 1; i < size; i++) {
            newArr[i - 1] = arr[i];
        }
        arr = newArr;
        size--;
        System.out.println("Element deleted successfully");
    }
    
    public void linearSearch(Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        
        for(int i = 0; i < size; i++) {
            if(arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }
    
    public void binarySearch(Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        
        int left = 0, right = size - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            }
            if(arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Element not found");
    }
    
    public void findMax() {
        int max = arr[0];
        for(int i = 1; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum value: " + max);
    }
    
    public void countEvenOdd() {
        int even = 0, odd = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }
    
    public void insertionSort() {
        for(int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted successfully");
    }
    
    public void display() {
        System.out.print("Array: ");
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayOperations ao = new ArrayOperations();
        
        ao.createArray(sc);
        
        while(true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1: ao.insert(sc); break;
                case 2: ao.delete(sc); break;
                case 3: ao.linearSearch(sc); break;
                case 4: ao.binarySearch(sc); break;
                case 5: ao.findMax(); break;
                case 6: ao.countEvenOdd(); break;
                case 7: ao.insertionSort(); break;
                case 8: ao.display(); break;
                case 9: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
