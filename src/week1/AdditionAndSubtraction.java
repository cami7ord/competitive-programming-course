package week1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdditionAndSubtraction {

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    static int solution(int x, int y, int z) {

        if (z == 0) {
            return 0;
        } else if (x == y) {
            if (z == x) return 1;
        }

        List list = new ArrayList<Integer>(1000);
        list.add(0,0);

        for (int i = 1 ; i < 2000 ; i++) {
            if (isEven(i)) {
                list.add(i, (int)list.get(i-1) - y);
            } else {
                list.add(i, (int)list.get(i-1) + x);
            }
            if ((int)list.get(i) == z) return i;
        }
        return -1;
    }


    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int result = -1;

        result = solution(x,y,z);

        out.println(result);

        in.close();
        out.close();
    }
}
