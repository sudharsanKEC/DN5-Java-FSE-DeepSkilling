import java.util.*;
class BinarySearch {
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
        System.out.print("Enter the element need to be found in the array: ");
        int element = sc.nextInt();
        boolean found = false;
        
        int left = 0;
        int right = n-1;

        // binary search logic
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>element){
                right = mid-1;
            }else if(arr[mid]<element){
                left = mid+1;
            }else{
                System.out.println("Element "+element+" found at: "+mid);
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
