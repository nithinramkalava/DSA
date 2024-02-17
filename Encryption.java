
import java.util.Scanner;

public class Encryption {
    public static String encryption(String s) {
            String clean = s.replaceAll("\\s+", "");
            int length = clean.length();
            double sqrt = Math.sqrt(length);
            int rows = (int) Math.floor(sqrt);
            int columns = (int) Math.ceil(sqrt);
            
            StringBuilder encryptedString = new StringBuilder();
            if (rows != columns) rows++ ;
            for(int i = 0; i < rows; i++){
                int nextCharIndex = i;
                while (nextCharIndex < length) {
                    encryptedString.append(clean.charAt(nextCharIndex));
                    nextCharIndex += columns;
                }
                encryptedString.append(" ");
            }
            return encryptedString.toString();
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        sc.close();
        System.out.println(encryption(message));
    }
}
