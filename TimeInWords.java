
import java.util.Scanner;

public class TimeInWords {
    static String[] ones_places = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
    static String[] the_teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};
    
    public static String timeInWords(int h, int m) {

        if (m == 0){
            return ones_places[h-1] + " o' clock";
        }

        if( m == 30 ){
            h = h-1;
            if (h == 0)  h = 12;
            return "half past " + ones_places[h];
        }

        if (m > 30){
            h = (h+1)%12;
            m = 60 - m;
            String msg = " minutes";
            if ( m == 15 ) msg = "";
            if (m == 1) msg = " minute";
            return minutesStringGenerator(m) + msg + " to " + ones_places[h-1];
        }

        if (m < 30){
            String msg = " minutes";
            if ( m == 15 ) msg = "";
            if (m == 1) msg = " minute";
            return minutesStringGenerator(m) + msg + " past " + ones_places[h-1];
        }

        return "0";
    }
    
    private static String minutesStringGenerator(int m){


        if ( m/10 == 0) 
            return ones_places[m - 1];

        if (m/10 == 1)
            return the_teens[ m%10 ];
        
        return "twenty " + ones_places[(m%10) - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        // int h = Integer.parseInt(args[0]);
        // int m = Integer.parseInt(args[1]);
        System.out.println(timeInWords(h, m));
    }
}