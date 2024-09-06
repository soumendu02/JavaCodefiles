public class Minmaxele {
    public static void main(String[] args) {
        int[] arr={95,32,52,40,23};
        System.out.println(minElement(arr));
        System.out.println(maxElement(arr));
    }
    static int minElement(int[] array)
    {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<min)
            min=array[i];
        }
        return min;
    }
    static int maxElement(int[] array)
    {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max)
            {
                max=array[i];
            }
        }
        return max;
    }
}
