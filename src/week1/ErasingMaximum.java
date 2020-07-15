package week1;

import java.io.PrintWriter;
import java.util.Scanner;

public class ErasingMaximum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];

        int max = 0;
        int maxCounter = 0;
        int removeIndex = 0;

        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            if (a[i] > max) {
                max = a[i];
                maxCounter = 1;
                removeIndex = i;
            } else if (a[i] == max) {
                ++maxCounter;
                if (maxCounter == 3) {
                    removeIndex = i;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i != removeIndex) {
                if (i != 0) out.print(' ');
                out.print(a[i]);
            }
        }

        out.println();

        in.close();
        out.close();
    }
}
