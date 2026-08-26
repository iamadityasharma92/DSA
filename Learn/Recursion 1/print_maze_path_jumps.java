import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class print_maze_path_jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        gmp(1,1,3,3,"");
//        sc.close();
    }
    static void gmp(int sc,int sr,int dc,int dr,String psf) {
        if(sc==dc&&sr==dr){
            System.out.print(psf+",");
            return ;
        }
        for(int ms=1;ms<=dc-sc;ms++){
            if(sc+ms<=dc)
            gmp(sc+ms,sr,dc,dr,"v"+ms+psf);// these also have types not only 1 step like everytime
        }

        for(int ms=1;ms<=dr-sr;ms++){
            if(ms+sr<=dr)
            gmp(sc,sr+ms,dc,dr,"h"+ms+psf);
        }
        for(int ms=1;ms<=dr-sr && ms<=dc-sc;ms++){
            if(ms+sr<=dr && ms+sc<=dc)
                gmp(sc+ms,sr+ms,dc,dr,"d"+ms+psf);
        }

    }
}

