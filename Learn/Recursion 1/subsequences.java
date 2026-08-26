import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="abc";
        List<String> res=gss(str);
        System.out.println(res);
//        sc.close();
    }
    static List<String> gss(String str) {
        if(str.isEmpty())
            return new ArrayList<>(Arrays.asList(""));
        char ch=str.charAt(0);
        List<String> temp= gss(str.substring(1));
        int n=temp.size();
        for(int i=0;i<n;i++){
            temp.add(ch+temp.get(i));
        }
        return temp;
    }
}

