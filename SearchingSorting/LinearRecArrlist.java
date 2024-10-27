// package SearchingSorting;
import java.util.ArrayList;

public class LinearRecArrlist {
    public static void main(String[] args) {
        int[] arr={1,5,4,5,6,7};
        ArrayList<Integer> list=findAllIndex(arr, 5, 0);
        System.out.println(list);
    }
    static ArrayList<Integer> findAllIndex(int[] arr,int target,int index){
        ArrayList<Integer> listOfIndices=new ArrayList<>();
        if(index==arr.length)
        {
            return listOfIndices;
        }
        if(arr[index]==target)
        {
            listOfIndices.add(index);
        }
        ArrayList<Integer> answersFromBelowCalls=findAllIndex(arr, target, index+1);
        listOfIndices.addAll(answersFromBelowCalls);
        return listOfIndices;
    }
}
