import java.util.Scanner;

public class Power_Linear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res=pow(n,4);
        System.out.println(res);

        sc.close();
    }
    static int pow(int x,int n) {
        if (n == 1) return x;

        return pow(x,n-1)*x;

    }
}
