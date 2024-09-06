/**
 * Skipchar
 */
public class Skipchar {

    public static void main(String[] args) {
        System.out.println(skipString("baapplcaadastringachiapple"));
    }
    static String skipEle(String unprocessed)
    {
        if(unprocessed.isEmpty())
        {
            return "";
        }
        char ch=unprocessed.charAt(0);
        if(ch=='a')
        {
            return skipEle(unprocessed.substring(1));
        }
        return ch+skipEle(unprocessed.substring(1));

    }
    static String skipString(String unprocessed)
    {
        if(unprocessed.isEmpty())
        {
            return "";
        }
        if(unprocessed.startsWith("string"))
        {
            return skipString(unprocessed.substring(5));
        }
        return unprocessed.charAt(0)+skipString(unprocessed.substring(1));

    }
}