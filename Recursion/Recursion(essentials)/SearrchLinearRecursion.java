//package Recursion;
public class SearrchLinearRecursion {
    public static void main(String[] args) {
        int[] array={1,3,5,6,79,19};
        System.out.println(search(array, 9, 0));
    }
    static int search(int[] arr , int target , int index )
    {
        if( index == arr.length )
        {
            return -1;
        }
        if(target == arr[index] )
        {
            return index;
        }
        else{
            return search(arr, target, index+1);
        }
    }
}
