import java.util.Scanner;

public class first_index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int x=20;
        int[] arr= new int[]{10,20,123,30,-40,30,50,20};
        int idx=firstIndex(arr,0,x);
        System.out.println(idx);
        sc.close();
    }
    static int firstIndex(int[] arr,int idx,int x) {
        if (arr.length == idx) return -1;

        if(arr[idx]==x){
            return idx;
        }else {
            int foundIdx = firstIndex(arr, idx + 1, x);
//        if(arr[idx]==x){
//            if(foundIdx!=-1)
//                foundIdx=Math.min(foundIdx,idx);
//        }

            return foundIdx;
        }
    }
}

