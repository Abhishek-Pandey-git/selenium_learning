import java.util.Scanner;
public class TwoDArraySumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] arr = new int[2][2];
        
        System.out.println("Enter elements for 2x2 array:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\nThe 2D Array is:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum += arr[i][j];
            }
        }
        
        double avg = sum / 4.0;
        
        System.out.println("\nSum of all elements: " + sum);
        System.out.println("Average of all elements: " + avg);
        
        sc.close();
    }
}
