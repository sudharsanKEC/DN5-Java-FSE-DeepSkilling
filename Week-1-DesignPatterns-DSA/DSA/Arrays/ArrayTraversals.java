
import java.util.*;
class ArrayTraversals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements in ascending order: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Array forward traversal: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Array backward traversal: ");
        for(int i = n-1; i >= 0; i--){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\nArray traversals completed from both ways.");
        
    }
}
