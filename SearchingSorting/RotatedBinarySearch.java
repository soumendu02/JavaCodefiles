public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,6,7};
        System.out.println(searchByRecursion(arr, 5,0,arr.length-1));
    }
    static int searchByRecursion(int[] arr,int key,int start,int end)
    {
        if(start>end)
        {
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==key)
        {
            return mid;
        }
        if(arr[start]<=arr[mid])
        {
            if(key>=arr[start]  && key<=mid )
            {
                return searchByRecursion(arr, key, start, mid-1);
            }
            else{
                return searchByRecursion(arr, key, mid+1, end);
            }
        }
        if(key>=arr[mid] && key<=arr[end])
        {
            return searchByRecursion(arr, key, mid+1, end);
        }
        return searchByRecursion(arr, key, start, mid-1);   
    }
    static int searchElement(int[] arr,int target)
    {
        int pivot=findPivot(arr);
        if(pivot==-1)
        {
            return binarySearch(arr, target, 0, arr.length-1);
        }
        if(pivot== target)
        {
            return pivot;
        }
        if(target>arr[0])
        {
            return binarySearch(arr, target, 0, pivot-1);
        }
        return binarySearch(arr, target, pivot+1, arr.length-1);
    }
    static int findPivot(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start <= end)
        {
            int mid=start+(end-start)/2;
            if(mid < end && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            else if(mid>start && arr[mid-1]>arr[mid])
            {
                return mid-1;
            }
            else if(arr[mid] <= arr[start])
            {
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr,int target,int start,int end)
    {
        int mid=start+(end-start)/2;
        if(start > end)
        {
            return -1;
        }
        if(arr[mid]==target)
        {
            return mid;
        }
        else if(target>arr[mid])
        {
            return binarySearch(arr, target, mid+1, end);
        }
        return binarySearch(arr, target, start, mid-1);
    }
}
