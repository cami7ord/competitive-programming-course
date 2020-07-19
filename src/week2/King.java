package week2;

import java.io.PrintWriter;
import java.util.Scanner;

public class King {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r, c;
        r = in.nextInt();
        c = in.nextInt();

        int blanks = (int) ((Math.ceil(r/3d)) * (Math.ceil(c/3d)));
        int result = (r*c) - blanks;

        out.println(result);

        in.close();
        out.close();
    }
}
