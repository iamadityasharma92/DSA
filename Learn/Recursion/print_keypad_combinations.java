import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class print_keypad_combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="678";
        print_KPC(str,"");
        System.out.println(" -> "+count);
//        sc.close();
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static int count = 0;
    static void print_KPC(String ques,String ans) {
        if(ques.isEmpty()){
            count++;
            System.out.print(ans+",");
            return;
        }

        char ch=ques.charAt(0);
//        print_KPC(ques.substring(1),ans);// ye empty valli code nahi jayegi isme coz these are not subsequence ki ek baar occur ho alphabet and next time na ho
        String key = codes[ch-'0'];
        for(int i=0;i<key.length();i++) {
            char c=key.charAt(i);
            print_KPC(ques.substring(1),key.charAt(i)+ans);

        }
    }
}

