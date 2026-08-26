import java.util.Scanner;

public class print_abbreviations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="pep";
        solution(str,"",0,0);
//        sc.close();
    }
    static void solution(String str,String asf,int count, int pos) {
        if (pos == str.length()) {
            if(count>0)
            System.out.println(asf+count);
            else
                System.out.println(asf);
            return;
        }
        // count reset to 0 needed otherwise it will cause increase in no. of characters in abbreviations
        if(count>0){
            solution(str,asf+count+str.charAt(pos),0,pos+1);
        }else {
            solution(str,asf+str.charAt(pos),0,pos+1);
        }
        solution(str,asf,count+1,pos+1);
    }
}

