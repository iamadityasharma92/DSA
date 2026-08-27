import java.util.Scanner;

public class josephus_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int n=6,k=3;
        System.out.println(solution(n,k));
//        sc.close();
    }
    static int solution(int n,int k) {
        if(n==1) return 0;

        int x=solution(n-1,k);
        int y=(x+k)%n;
        return y;

    }
}

