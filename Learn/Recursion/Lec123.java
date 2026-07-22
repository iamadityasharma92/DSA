import java.util.Scanner;

public class Lec123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PDI(n);
        sc.close();
    }
    static void PDI(int n) {
        if(n==0) return;

        System.out.println(n);
        PDI(n-1);
        System.out.println(n);
    }
}
