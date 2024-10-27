import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] arr={5,4,-2,0,1};
        selectionByRecursion(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int last=arr.length-i-1;
            int maxIndex=getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }
    static void swap(int[] arr, int last, int maxIndex) {
        int temp;
        temp=arr[last];
        arr[last]=arr[maxIndex];
        arr[maxIndex]=temp;
    }
    static int getMaxIndex(int[] arr, int start, int last) {
        int max=start;
        for (int i = start; i <= last; i++) {
            if(arr[max]<arr[i])
                max=i;
        }
        return max;
    }
    static void selectionByRecursion(int[] arr,int r,int c,int maxIndex)
    {
        if(r==0)
        {
            return;
        }
        if(c<r)
        {
            if(arr[c] > arr[maxIndex])
            {
                selectionByRecursion(arr, r, c+1, c);
            }
            else
            {
                selectionByRecursion(arr, r, c+1, maxIndex);
            }
        }
        else{//AFTER ONE ROW WHEN WE GO TO NEXT ROW THEN PLACE MAX ELEMENT IN LAST POSITION
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[r-1];
            arr[r-1]=temp;
            selectionByRecursion(arr, r-1, 0, 0);
        }
    }

}
