import java.util.Scanner;

public class last_index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int x=10;
        int[] arr= new int[]{10,20,123,30,-40,30,10,50,20};
        int idx=lastIndex(arr,0,x);
        System.out.println(idx);
        sc.close();
    }
    static int lastIndex(int[] arr,int idx,int x) {
        if (arr.length == idx) return -1;

        int foundIdx=lastIndex(arr,idx+1,x);
        if(foundIdx==-1 && arr[idx]==x)
            foundIdx=idx;
//        if(arr[idx]==x){
//            if(foundIdx!=-1)
//                foundIdx=Math.max(foundIdx,idx);
//            else
//                foundIdx=idx;
//        }
        return foundIdx;
    }
}

