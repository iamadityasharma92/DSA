import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class get_maze_path {
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
        List<String> hpaths=new ArrayList<>();
        List<String> vpaths=new ArrayList<>();

        if(sc<=dc){
            vpaths=gmp(sc+1,sr,dc,dr);
        }
        if(sr<=dr){
            hpaths=gmp(sc,sr+1,dc,dr);
        }
        List<String> paths = new ArrayList<>();
        for(String i:hpaths){
            paths.add("h"+i);
        }
        for(String i:vpaths){
            paths.add("v"+i);
        }
        return paths;
    }
}

