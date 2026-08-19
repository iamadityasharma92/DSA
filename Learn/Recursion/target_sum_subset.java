import java.util.Scanner;

public class target_sum_subset {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] arr = new int[]{10,20,30,40,50};
        int tar = 50;

        printTargetSumSubsets(arr, 0, "", 0, tar);

//        sc.close();
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx == arr.length){
            if(sos==tar){
                System.out.println("["+set+"]");
            }
            return;
        }
        if(sos>tar){
            return;
        }
        printTargetSumSubsets(arr,idx+1,set,sos,tar);
        printTargetSumSubsets(arr,idx+1,set+arr[idx]+",",sos+arr[idx],tar);
    }
}
