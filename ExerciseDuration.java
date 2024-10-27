import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ExerciseDuration {
    static public int extractTime( String input ) {
        StringBuilder sb = new StringBuilder();
        for( int k = input.length() - 1 ;k >= 0 ; k-- ){
            if( input.charAt(k) <= '9' && input.charAt(k) >= '0')
                sb.append( input.charAt( k ) );
            else
                break;
        }
        return Integer.parseInt( sb.reverse().toString() );
    }
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        double sum = 0;
        for( int i = 0 ; i < 7; i++ )
        {
            sum += extractTime( br.readLine() );
        }
        double avg = sum / 7;
        System.out.println( "The total workout time of the week is " + sum + " minutes" );
        System.out.print( " The average workout time per day is " );
        System.out.format( "%.3f" , avg );
        System.out.print(  " minutes" );
    }
}
