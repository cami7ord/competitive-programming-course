package week1;

import java.io.PrintWriter;
import java.util.Scanner;

public class Increment {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String x;
        x = in.next();

        if (x.equals("9")) {
            out.println(2);
        }
        else if (x.length() == 1) {
            out.println(1);
        } else {

            boolean diff = false;

            for (int i=x.length()-1 ; i>=0 ; --i) {
                if (x.charAt(i) != '9') {
                    diff = true;
                    break;
                }
            }

            if (diff) {
                out.println(x.length());
            } else {
                out.println(x.length() + 1);
            }
        }

        in.close();
        out.close();
    }
}
