public class Binarysearchrecursion {
    public static void main(String[] args) {
        int[] arr={1,2,55,78,119};
        System.out.println(binarysearch(arr, 0, arr.length-1, 8));
        System.out.println(check(arr,0));
    }
    static int binarysearch(int[] arr,int start,int end,int target)
    {
        if(start>end)
        {
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target)
        {
            return mid;
        }
        if(target<arr[mid])
        {
            return binarysearch(arr, start, mid-1, target);
        }
        return binarysearch(arr, mid+1, end, target);
    }
}
