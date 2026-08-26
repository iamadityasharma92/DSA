import java.util.Scanner;

public class print_permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="abc";
        print_permutation(str,"");
//        sc.close();
    }
    static void print_permutation(String ques,String ans) {
        if(ques.isEmpty()){
            System.out.print(ans+",");
            return;
        }
        for(int i=0;i<ques.length();i++){
            char ch=ques.charAt(i);
            String ros= ques.substring(0,i)+ques.substring(i+1);
            print_permutation(ros,ans+ch);
        }
    }
}

