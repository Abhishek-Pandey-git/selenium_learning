import java.util.Scanner;
public class MaxElement{
    public static void main(String[] args){
        int size;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the size of array");
        size=input.nextInt();
        int[] arr=new int[size];
        int maxi=arr[0];

        for(int i=0;i<size;i++){
            System.out.println("Enter element for "+i+" th index");
            arr[i]=input.nextInt();
            if(arr[i]>maxi){
                maxi=arr[i];
            }
        }
        System.out.println("The element with maximum value is: "+maxi);
        input.close();
    }
}