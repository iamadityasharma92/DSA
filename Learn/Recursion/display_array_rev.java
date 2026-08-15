import java.util.Scanner;

public class display_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int x=2;
        int[] arr= new int[]{10,20,30,40,50};
        disp(arr,0);

        sc.close();
    }
    static void disp(int[] arr,int idx) {
        if (arr.length == idx) return ;

        System.out.println(arr[idx]);
        disp(arr,idx+1);


    }
}

