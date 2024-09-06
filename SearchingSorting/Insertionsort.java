package SearchingSorting;
import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        int[] array={-1,5,0,3,4};
        insertion(array);
        System.out.println(Arrays.toString(array));
        int[] nums={5,8,32,1,2,98};
        insertionByRecursion(nums, 0);
        System.out.println(Arrays.toString(nums));
    }
    static void insertion(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=i+1;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }

            }
        }
    }
    static void swap(int[] arr,int last,int start)
    {
        int temp;
        temp=arr[last];
        arr[last]=arr[start];
        arr[start]=temp;
    }
    static void insertionByRecursion(int[] nums,int i)
    {
        if(i==nums.length-1)
        {return;}
        int j=i+1;
        while(j>0 && nums[j-1]>nums[j])
        {
            swap(nums, j-1, j);
            j--;
        }
        insertionByRecursion(nums, i+1);
    }
}
