import java.util.Scanner;

public class TOI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x=2;
        toi(3,'A','B','C');

        sc.close();
    }
    static void toi(int n,char a,char b,char c) {
        if (n == 0) return ;

        toi(n-1,a,c,b);
        System.out.println(n+"[ "+a+"->"+b+" ]");
        toi(n-1,c,b,a);


    }
}

