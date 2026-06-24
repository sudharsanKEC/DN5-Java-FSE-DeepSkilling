import java.util.*;
public class ArrayTraversal{
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter array elements: ");
    for(int i = 0; i < n; i++){
      System.out.println(arr[i]);
    }
    System.out.println("Array elements has been printed while traversing along with it.");
  }
}
