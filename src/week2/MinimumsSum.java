package week2;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class MinimumsSum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result = result.add(BigInteger.valueOf(minOf(a, i, j)));
            }
        }

        out.println(result);

        in.close();
        out.close();
    }

    private static int minOf(int[] a, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; ++k) {
            if (a[k] < min) {
                min = a[k];
            }
        }
        return min;
    }
}

/*

First of all, instead finding a minimum of each segment we will find all segments where some element a[i] is minimum.

There are some issues

we can't find all segments one by one (there O(n^2) segments in total, but we can find number of such segments for all a[i]
one segment can have more then one minimum element (we still should not process such segment more than once)
So, let b[i] is number if segments where a[i] is the leftmost minimum.

To find b[i] we need to values:

L[i] -- how many consecutive numbers to the left of a[i] greater than a[i]

R[i] -- how many consecutive numbers to the right of a[i] greater than or equal to a[i]

Then, b[i] = (L[i] + 1) * (R[i] + 1).

For example,

a = [1, 2, 3, 1, 2, 3]

L= [0, 0, 0, 2, 0, 0]

R = [5, 1, 0, 2, 1, 0]

To find array L we can walk from left to right and remember some increasing subsequence of elements to find L[i] in O(1) amortized time.

Even O(n) solution exists, one can use a stack data structure for it.

 */
