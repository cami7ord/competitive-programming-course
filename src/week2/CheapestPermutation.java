package week2; //TODO remove the package before sending

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheapestPermutation {
    static List<int[]> permutations(int n) {

        List<int[]> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        permute(results, "", sb.toString());
        return results;
    }

    static void permute(List<int[]> results, String prefix, String remaining) {
        if (remaining.isEmpty()) {
            int[] integers = new int[prefix.length()];
            for (int i = 0; i < prefix.length(); ++i) {
                integers[i] = Integer.parseInt(String.valueOf(prefix.charAt(i)));
            }
            results.add(integers);
        } else {
            for (int i = 0; i < remaining.length(); ++i) {
                permute(results,
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1));
            }
        }
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                a[i][j] = in.nextInt();

        int[] result = new int[n];

        int min = Integer.MAX_VALUE;
        List<int[]> permutations = permutations(n);

        for (int[] p : permutations) {
            int cost = 0;
            for (int i = 0; i < p.length-1; ++i) {
                cost += a[p[i]-1][p[i+1]-1];
            }
            if (cost < min) {
                min = cost;
                result = p;
            }
        }

        for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }
}
