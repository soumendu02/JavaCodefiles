import java.util.Scanner;

public class Mock {
    public static void main(String[] args)
    {
        
        Scanner in=new Scanner(System.in);
        String str=in.next();
        // System.out.println(str.charAt(0)>='a');
        // System.out.println(str.replace(str.charAt(3),(char)(str.charAt(3)+1)));
        
        System.out.println(find(str));
    }
    static String find(String str)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            if((str.charAt(i)>='a' && str.charAt(i)<='z') || (str.charAt(i)>='A' && str.charAt(i)<='Z'))
            {
                char c=str.charAt(i);
                c=(char)(str.charAt(i)+1);
                if(c=='i' || c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                {
                    c=Character.toUpperCase(c);
                }
                sb.append(c);
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        sb.reverse();
        str=sb.toString();
        return str;
    }
}
