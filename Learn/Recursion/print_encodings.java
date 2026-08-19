import java.util.Scanner;

public class print_encodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        String str="12103";
        print_encode(str,"");
//        sc.close();
    }
    static void print_encode(String ques,String asf) {
        if(ques.isEmpty()){
            System.out.print(asf+",");
            return;
        }else if(ques.length()==1){
            char ch=ques.charAt(0);
            if(ch=='0'){
                return;
            }else{
                char code = (char)('a'+(ch-'0')-1);
                System.out.print(asf+code+",");
            }
        }else{
            char ch=ques.charAt(0);
            if(ch=='0'){
                return;
            }else{
                String ros=ques.substring(1);
                char code =(char)('a'+(ch-'0')-1);
                print_encode(ros,asf+code);
                String ch12= ques.substring(1,2);
                String ros1= ques.substring(2);
                int codeNum= Integer.parseInt(ch+ch12);
                if(codeNum<=26){
                char code2= (char)('a'+codeNum-1);
                print_encode(ros1,asf+code2);
                }
            }
        }
    }
}

