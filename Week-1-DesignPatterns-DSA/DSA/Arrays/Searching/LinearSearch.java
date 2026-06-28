
import java.util.*;
class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element need to be found in the array: ");
        int element = sc.nextInt();
        boolean found = false;
        
        for(int i = 0; i < n; i++){
            if(arr[i] == element){
                System.out.println("Element "+element+" found at position: "+i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Given element not found in the array");
        }
        System.out.println("--------------------------------");
        
    }
}

// Best case: If the given element is found at the 0th index position then the TC will be O(1)
// Average case: If the given element is found somewhere in between the array then it will probably O(n/2) ~ O(n).
// Worse case: If the given element is at the last position of the array then the TC will be O(n).

// If element is not in the array then O(n).

// When the array elements is scattered then linear search is the only way to find the element.
// But if the array element is ordered either on ascending or descending order then using linear search is inefficient, because for sorted arrays using Binary search is much more efficient. 
// Binary Search guarantees a TC of O(log n).








