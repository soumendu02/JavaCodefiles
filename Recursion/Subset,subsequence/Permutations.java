import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        // permutations("", "abc");
        ArrayList<String> list=new ArrayList<>();
        list=permute("", "abac");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println(numberOfPermutations("", "aabc"));
    }
    static void permutations(String p,String up){
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++)
        {
            String first=p.substring(0, i);
            String second=p.substring(i,p.length());
            permutations(first+ch+second, up.substring(1));
        }
    }
    static ArrayList<String> permute(String p,String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++)
        {
            String f=p.substring(0, i);
            String s=p.substring(i,p.length());
            ans.addAll(permute( f+ch+s, up.substring(1)));
        }
        return ans;
    }
    static int numberOfPermutations(String p,String up)
    {
        if(up.isEmpty())
        {
            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        for(int i=0;i<=p.length();i++)
        {
            String first=p.substring(0, i);
            String second=p.substring(i,p.length());
            count=count+numberOfPermutations(first+ch+second, up.substring(1));
        }
        return count;
    }
}
