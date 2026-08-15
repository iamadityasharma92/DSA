import java.util.Scanner;

public class max_of_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int x=2;
        int[] arr= new int[]{10,20,123,30,-40,50};
        int maxi=maxOfArray(arr,0);
        System.out.println(maxi);
        sc.close();
    }
    static int maxOfArray(int[] arr,int idx) {
        if (arr.length == idx) return Integer.MIN_VALUE;

        int maxi=maxOfArray(arr,idx+1);
        return Math.max(maxi,arr[idx]);
    }
}

