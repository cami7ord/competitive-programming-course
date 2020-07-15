package week1;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StraightFlush {

    static boolean flush(String[] arg) {
        char suit = arg[0].charAt(1);
        for (int i = 1; i < arg.length; i++) {
            if (arg[i].charAt(1) != suit) {
                return false;
            }
        }
        return true;
    }

    static int calculateValue(String ss) {
        switch (ss.charAt(0)) {
            case 'A':
                return -1;
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            case 'T':
                return 10;
            default:
                return Integer.parseInt(ss.substring(0,1));
        }
    }

    static boolean straight(String[] arg) {

        int min = 15;
        int max = 0;

        List<Integer> values = new ArrayList<>(5);

        for (int i = 0; i < arg.length; i++) {
            int value = calculateValue(arg[i]);
            values.add(value);

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
        }
        return compareToSequence(values, min, max);
    }

    static boolean compareToSequence(List<Integer> values, int min, int max) {
        List<Integer> cards = new ArrayList<>(5);
        if (min == -1) {
            if (max == 13) {
                cards = Arrays.asList(-1,13,12,11,10);
            } else if (max == 5) {
                cards = Arrays.asList(5,4,3,2,-1);    
            } else {
                return false;
            }
        } else {
            cards = new ArrayList<>();
            for (int i = 0; i <5 ; i++) {
                cards.add(max-i);
            }
        }

        if (values.containsAll(cards)) {
            return true;
        }
        return false;
    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String[] a = new String[5];

        for (int i=0 ; i<5 ; ++i) {
            a[i] = in.next();
        }

        if (flush(a) && straight(a)) {
            out.println("YES");
        } else {
            out.println("NO");
        }

        in.close();
        out.close();
    }
}
