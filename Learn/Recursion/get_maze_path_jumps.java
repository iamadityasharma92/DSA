import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class get_maze_path_jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        List<String> res=gmp(1,1,3,3);
        System.out.println(res);
//        sc.close();
    }
    static List<String> gmp(int sc,int sr,int dc,int dr) {
        if(sc==dc&&sr==dr){
            return new ArrayList<>(Arrays.asList(""));
        }
        List<String> paths = new ArrayList<>();

        for(int ms=1;ms<=dc-sc;ms++){
            List<String> vpaths=new ArrayList<>();
            if(sc+ms<=dc)
            vpaths=gmp(sc+ms,sr,dc,dr);// these also have types not only 1 step like everytime
            for(String s:vpaths)
                paths.add("v"+ms+s);
        }

        for(int ms=1;ms<=dr-sr;ms++){
            List<String> hpaths=new ArrayList<>();
            if(ms+sr<=dr)
            hpaths=gmp(sc,sr+ms,dc,dr);
            for(String s:hpaths)
                paths.add("h"+ms+s);
        }
        for(int ms=1;ms<=dr-sr && ms<=dc-sc;ms++){
            List<String> dpaths=new ArrayList<>();
            if(ms+sr<=dr && ms+sc<=dc)
                dpaths=gmp(sc+ms,sr+ms,dc,dr);
            for(String s:dpaths)
                paths.add("d"+ms+s);
        }

        return paths;
    }
}

