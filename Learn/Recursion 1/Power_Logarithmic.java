import java.util.Scanner;

public class Power_Logarithmic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x=3;
        int res=pow(n,x);
        System.out.println(res);

        sc.close();
    }
    static int pow(int x,int n) {
        if (n == 0) return 1;

        int xpnb2= pow(x,n/2);
        int xn=xpnb2*xpnb2;

        if(n%2==1){
            xn*=x;
        }
        return xn;
    }
}
