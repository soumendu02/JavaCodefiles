import java.util.ArrayList;

public class Allsubsets {
    public static void main(String[] args) {
        subset("", "abcd");
        ArrayList<String> res=subsetRet("", "abc");
        for (String string : res) {
            System.out.println(string);
        }
    }
    static void subset(String processed,String unprocessed)
    {
        if(unprocessed.isEmpty())
        {
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        subset(processed + ch, unprocessed.substring(1,unprocessed.length()));
        subset(processed, unprocessed.substring(1));
    }
    static ArrayList<String> subsetRet(String p,String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subsetRet(p, up.substring(1));
        ArrayList<String> right=subsetRet(p+ch, up.substring(1));
        left.addAll(right);
        return left;
    }
}
