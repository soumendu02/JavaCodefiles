public class PatternRecursion {
    public static void main(String[] args) {
        invertedTriangle(5, 0);
    }
    static void invertedTriangle(int rows,int cols)
    {
        if(rows==0)
        {
            return;
        }
        if(cols<rows)
        {
            System.out.print("*");
            invertedTriangle(rows, cols+1);
        }
        else{
            System.out.println();
            invertedTriangle(rows-1,0);
        }
    }
    static void triangle(int r,int c)
    {
        if(r==0)
        {
            return;
        }
        if(c < r){
            triangle(r, c+1);
            System.out.print("*");
        }
        else{
            triangle(r-1, 0);
            System.out.println();
        }
    }
}
