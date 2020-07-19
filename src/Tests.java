import java.io.PrintWriter;
import java.util.Scanner;

public class Tests {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        out.println(n);

        in.close();
        out.close();
    }
}
