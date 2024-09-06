
public class CheckSortedArray {
    public static void main(String[] args) {
        int[] array={-1,0,70,80};
        System.out.println(check(array, 0));
    }
    public static boolean check(int[] arr, int index)
    {
        if( index == arr.length-1 )
        {
            return true;
        }
        return arr[index] < arr[index+1] && check(arr, index+1);
    }  
}
