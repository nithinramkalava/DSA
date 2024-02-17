import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        
        BigInteger fact = new BigInteger("1");
        
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println(fact);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        extraLongFactorials(n);
    }
}
