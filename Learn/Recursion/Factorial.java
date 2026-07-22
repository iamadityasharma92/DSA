import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res=fact(n);
        System.out.println(res);

        sc.close();
    }
    static int fact(int n) {
        if (n == 1) return n;

        return fact(n - 1)*n;

    }
}
