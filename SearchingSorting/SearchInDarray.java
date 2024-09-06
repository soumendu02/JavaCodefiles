package SearchingSorting;
import java.util.Arrays;

public class SearchInDarray {
    public static void main(String[] args) {
        int[][] arr={
            {0,1,2,3}, 
            {4,5,6,7}, 
            {8,9,10,11}
        };
        System.out.println(Arrays.toString(search(arr, 6)));
    }
    static int[] search(int[][] array,int target)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]==target)
                return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
