import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class print_stairs_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        gsp(4,"");
//        sc.close();
    }
    static void gsp(int n,String psf) {
//        optimised or clean code
        if(n==0){
            System.out.print(psf+",");
            return ;
        }
        for(int i=1;i<=3;i++){
            if(n-i>=0){
                gsp(n-i,i+psf);
            }
        }

//        if(n==0){
//            System.out.print(psf+",");
//            return ;
//        }else if(n<0) {
//            return ;
//        }
//        gsp(n-1,"1"+psf);
//        gsp(n-2,"2"+psf);
//        gsp(n-3,"3"+psf);

    }
}

