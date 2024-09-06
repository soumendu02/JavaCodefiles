package SearchingSorting;
import java.util.*;
public class Linsearcstr {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter element to be found");
        char target=in.next().charAt(0);
        System.out.println("enter string");
        String str=in.next();
        System.out.println(linsearc(str,target));
    }
    static boolean linsearc(String str ,char target)
    {
        
        if(str.length()==0)
        {
            return false;
        }
        else{
            for (int i = 0; i < str.length(); i++) {
                if(target==str.charAt(i))
                {
                    return true;
                }
                
            }
        }
        return false;
    }
}
