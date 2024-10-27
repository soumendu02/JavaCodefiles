import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
class HeapSort{
    static void sort(int[] nums)
    {
        int N=nums.length;
        for(int i=(N/2)-1;i>=0;i--)
        {
            heapify(nums,N,i);              //CREATE THE HEAP FROM UNSORTED ARRAY
        }
        for(int i=N-1;i>=0;i--)
        {
            int temp=nums[0];    // )---------|
            nums[0]=nums[i];     //           |-----> TAKING OUT THE LAST ELEMENT AND PUTTING IN THE ROOT OF THE TREE
            nums[i]=temp;        // )---------|
            heapify(nums,i,0); //THEN REARRANGING THE HEAP TO KEEP THE MAX ELEMENT AT THE FRONT
        }
    }
    static void heapify(int[] nums,int n,int i)
    {
        int largestInd=i;
        int leftInd=2*i+1;
        int rightInd=2*i+2;
        if(leftInd<n && nums[leftInd]>=nums[largestInd])
        {
            largestInd=leftInd;  
        }
        if(rightInd<n && nums[rightInd]>=nums[largestInd])
        {
            largestInd=rightInd;
        }
        if(largestInd!=i) //IF THE CURRENT NODE IS NOT LARGEST THEN SWAP WITH LARGEST ELEMENT (EITHER LEFT OR RIGHT CHILD)
        {
            int temp=nums[largestInd];
            nums[largestInd]=nums[i];
            nums[i]=temp;
            heapify(nums, n, largestInd); // REARRANGE THE SUBTREE BELOW LARGEST VALUED NODE
        }
    }
    static void heapSortByUisngCollections(int[] nums)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int integer : nums) {
            pq.offer(integer);
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            nums[i]=pq.poll();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements of array");
        int n= Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        System.out.print("Before sorting--->");
        System.out.println(Arrays.toString(arr));
        System.out.print("After sorting--->");
        // sort(arr);
        heapSortByUisngCollections(arr);
        System.out.println(Arrays.toString(arr));
    }
}