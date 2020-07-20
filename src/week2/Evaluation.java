package week2;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Evaluation {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = in.next();
        BigInteger result = BigInteger.ZERO;

        String[] sections = s.split("\\+");
        for (String section : sections) {
            String[] subsections = section.split("\\-");
            BigInteger subresult = BigInteger.valueOf(Long.parseLong(subsections[0]));
            for (int i = 1; i < subsections.length; i++) {
                subresult = subresult.subtract(BigInteger.valueOf(Long.parseLong(subsections[i])));
            }
            result = result.add(subresult);
        }

        out.println(result);

        in.close();
        out.close();
    }
}

/*
1. split string by plus
2. each item split by minus and evaluate
3. sum all results of the second step
 */
