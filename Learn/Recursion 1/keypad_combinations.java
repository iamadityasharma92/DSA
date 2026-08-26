import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class keypad_combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="573";
        List<String> res=getKPC(str);
        System.out.println(res+" -> "+res.size());
//        sc.close();
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static List<String> getKPC(String str) {
        if(str.isEmpty())
            return new ArrayList<>(Arrays.asList(""));// atleast size becomes 1
        char ch=str.charAt(0);
        List<String> temp= getKPC(str.substring(1));
        List<String> res= new ArrayList<>();
        int n=temp.size();
        String key = codes[ch-'0'];
        for(int i=0;i<key.length();i++) {
            char c=key.charAt(i);

            for (int j = 0; j < n; j++) {
                res.add(c + temp.get(j));
            }
        }
        return res;
    }
}

