import java.util.Scanner;

public class lexographical_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int n=1000;
        // we need to print family of 1's digit
//        for(int i=1;i<=9;i++){
//            System.out.println();
//            solution(i,n);
//        }
        int maxLength = 3; // Maximum length of strings to generate

        // Start the DFS with an empty string
        generateStrings("", maxLength);
//        sc.close();
    }
    static void solution(int i,int n) {
        if(i>n) return ;
        System.out.print(i+" ");
        for(int j=0;j<=9;j++)
        solution(10*i+j,n);

    }
    static void generateStrings(String current, int maxLength) {
        // Base case: stop if the string exceeds the maximum length
        if (current.length() > maxLength) {
            return;
        }

        // Print the current valid string (skip printing the empty initial string)
        if (!current.isEmpty()) {
            System.out.print(current + " ");
        }

        // Append characters 'a' through 'z' to create the next family generation
        for (char ch = 'a'; ch <= 'z'; ch++) {
            generateStrings(current + ch, maxLength);
        }
    }
}

