import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums={5,4,1,2,3};
        nums=mergesort(nums);//ORIGINAL ARRAY NOT MODIFIED HENCE THE NEW SORTED ARRAY RETURNED FROM RECURSION CALLS IS COPIED INTO THE ORIGINAL ARRAY
        System.out.println(Arrays.toString(nums));

        int[] num2={56,55,28,68,92};
        mergeSortInplace(num2, 0, num2.length);
        System.out.println(Arrays.toString(num2));
    }
    static int[] mergesort(int[] arr)
    {
        //IF ARRAY LENGTH IS ONE RETURN THE ARRAY
        if(arr.length == 1)
        {
            return arr;
        }
        int mid=arr.length/2;
        int[] left=mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right=mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;
        int[] mergedArray=new int[left.length + right.length];
        while(i<left.length && j<right.length)
        {
            if(left[i]<right[j])
            {
                mergedArray[k]=left[i];
                i++;
            }
            else{
                mergedArray[k]=right[j];
                j++;
            }
            k++;
        }
        
        while(i<left.length)
        {
            mergedArray[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length)
        {
            mergedArray[k]=right[j];
            j++;
            k++;
        }
        return mergedArray;
    }
    static void mergeSortInplace(int[] nums,int start,int end)
    {
        if(end-start==1)
        {
            return;
        }
        int mid=(end+start)/2;
        mergeSortInplace(nums, start, mid);
        mergeSortInplace(nums, mid, end);
        mergeinplace(nums,start,mid,end);
    }
    private static void mergeinplace(int[] nums, int start, int mid, int end) {
        int[] mergedarray=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while(i<mid && j<end)
        {
            if(nums[i]<nums[j])
            {
                mergedarray[k]=nums[i];
                i++;
            }
            else{
                mergedarray[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mergedarray[k]=nums[i];
            i++;
            k++;
        }
        while(j<end)
        {
            mergedarray[k]=nums[j];
            j++;
            k++;
        }
        for (int k2 = 0; k2 < mergedarray.length; k2++) {
            nums[start + k2]=mergedarray[k2];
        }

    }
}
