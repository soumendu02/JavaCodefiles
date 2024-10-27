import java.util.Scanner;

class Linearsearch{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter element to be found");
        int target=in.nextInt();
        int[] arr;
        arr=new int[5];
        System.out.println("enter elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
        }
        in.close();
        System.out.println("ARRAY FOUND AT INDEX"+linearSearch(arr, target));
    }
    static int linearSearch(int[] arr , int target)
    {
        int element;
        if(arr.length==0)
        {
            return -1;
        }
        else{
            for (int i =0;i<arr.length;i++) {
                element=arr[i];
                if(element==target)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}