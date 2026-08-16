import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class print_subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="abc";
        print_ss(str,"");
//        sc.close();
    }
    static void print_ss(String ques,String ans) {
        if(ques.isEmpty()){
            System.out.print(ans+",");
            return;
        }
        char ch = ques.charAt(0);
        print_ss(ques.substring(1),ans);
        print_ss(ques.substring(1),ch+ans);
    }
}

