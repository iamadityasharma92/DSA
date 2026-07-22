import java.util.Scanner;

public class Print_ZIG_ZAG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x=2;
        pzz(n);

        sc.close();
    }
    static void pzz(int n) {
        if (n == 0) return ;

        System.out.println("Pre "+n);
        pzz(n-1);
        System.out.println("In "+n);
        pzz(n-1);
        System.out.println("Post "+n);



    }
}

