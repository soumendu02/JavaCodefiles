
import java.util.*;

public class Subsetsarray {
    public static void main(String[] args) {
        List<List<Integer>> res=subsetDuplicate(new int[]{1,3,3});
        for (List<Integer> arrayList : res) {
            System.out.println(arrayList);
        }
        
    }
    static List<List<Integer>> subse(int[] arr)
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int nums : arr)
        {
            int n=outer.size();
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(nums);
                outer.add(internal);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr)
    {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++)
        {
            start=0;
            if(i>0 && arr[i]==arr[i-1])
            {
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++)
            {
                ArrayList<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
