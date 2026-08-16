import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class print_maze_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        gmp(1,1,4,4,"");
//        sc.close();
    }
    static void gmp(int sc,int sr,int dc,int dr,String psf) {
        if(sc==dc&&sr==dr){
            System.out.print(psf+",");
            return;
        }
        if(sc<=dc){
            gmp(sc+1,sr,dc,dr,"v"+psf);
        }
        if(sr<=dr){
            gmp(sc,sr+1,dc,dr,"h"+psf);
        }

    }
}

