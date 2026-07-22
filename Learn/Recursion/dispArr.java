import java.util.Scanner;

public class dispArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x=2;
        int[] arr={1,2,3,4,5};
        disp(arr,0);

        sc.close();
    }
    static void disp(int[] arr,int idx) {
        if (idx == arr.length) return ;

        System.out.println(arr[idx]);
        disp(arr,idx+1);

    }
}

