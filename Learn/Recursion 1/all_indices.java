import java.util.Arrays;
import java.util.Scanner;

public class all_indices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int x=10;
        int[] arr= new int[]{10,20,123,30,-40,30,20,50,20};
        int[] indices=allIndex(arr,0,x,0);
        System.out.println(Arrays.toString(indices));
        sc.close();
    }
    static int[] allIndex(int[] arr,int idx,int x,int fsf) {
        if (arr.length == idx) return new int[fsf];
        if(arr[idx]==x) {
            fsf++;// calculate length of array while going deep in recursion
        }
         int[] foundArr=allIndex(arr,idx+1,x,fsf);
        if(arr[idx]==x) {
            foundArr[fsf - 1] = idx; // fill the array while coming back from recursion
        }
         return foundArr;
    }
}

