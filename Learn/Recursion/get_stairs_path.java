import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class get_stairs_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        List<String> res=gsp(4);
        System.out.println(res);
//        sc.close();
    }
    static List<String> gsp(int n) {
//        optimised or clean code
        if(n==0)return new ArrayList<>(Arrays.asList(""));
        List<String> res=new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(n-i>=0){
                List<String> temp= gsp(n-i);
                for(String s:temp){
                    res.add(i+s);
                }
            }
        }
        return res;

//        if(n==0){
//            return new ArrayList<>(Arrays.asList(""));
//        }else if(n<0) {
//            return new ArrayList<>();
//        }
//        List<String> ps1=gsp(n-1);
//        List<String> ps2=gsp(n-2);
//        List<String> ps3=gsp(n-3);
//        List<String> res= new ArrayList<>();
//        for(String i:ps1){
//            res.add(1+i);
//        }
//        for(String i:ps2){
//            res.add(2+i);
//        }
//        for(String i:ps3){
//            res.add(3+i);
//        }
//        return res;
    }
}

