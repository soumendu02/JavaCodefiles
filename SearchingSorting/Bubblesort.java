import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr={2,4,1,6,5,3};
        bubbleByRecursion(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void bubble(int[] arr)
    {
        boolean swapped;
        for(int i=0;i<arr.length;i++)
        {
            swapped=false;
            for(int j=1;j<arr.length-i;j++)
            {
                if(arr[j]<arr[j-1])
                {
                    int temp;
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            if(!swapped)
            {
                break;
            }
        }
    }
    static void bubbleByRecursion(int[] arr,int c,int r)
    {
        if(r==0)
        {
            return;
        }
        if(c<r)
        {
            if(arr[c]>arr[c+1])
            {
                int temp;
                temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubbleByRecursion(arr, c+1, r);
        }
        else{
            bubbleByRecursion(arr, 0, r-1);
        }
    }

}
