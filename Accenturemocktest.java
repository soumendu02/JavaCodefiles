import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Accenturemocktest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inputString=br.readLine();
        char[] inputArray=inputString.toCharArray();
        int start=0;
         for(int i=0;i<inputArray.length;i++)
        {
            int c=(int)inputArray[i];
            if( c>=65 && c<=90)
            {
                
                for(int j=start;j<=(i-1);j++)
                {
                    int currChar=(int)inputArray[j];
                    if(j==0)
                    {
                        System.out.print((char)(currChar-32));
                    }
                    else if(j==start && j!=0){
                        System.out.print((char)(currChar+32));
                    }
                    else{
                        System.out.print((char)(currChar-32));
                    }
                    
                }
                start=i;
                System.out.println();
            }
            if (i==inputArray.length-1)
            {
                for(int j=start;j<=(i);j++)
                {
                    int currChar=(int)inputArray[j];
                    if(j==start){
                        System.out.print((char)(currChar+32));
                    }
                    else{
                        System.out.print((char)(currChar-32));
                    }
                }
            }
        }

    }
}
