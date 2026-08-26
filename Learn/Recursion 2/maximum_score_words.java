import java.util.Scanner;

public class maximum_score_words {

    // Main driver method
    public static void main(String[] args) {
        // 1. Hardcoded sample input arrays
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};

        // 2. Scores for 'a' through 'z' (26 elements)
        int[] score = {
                1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0,
                0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };

        // 3. Handle edge cases
        if (words == null || words.length == 0 || letters == null || letters.length == 0) {
            System.out.println(0);
            return;
        }

        // 4. Build the character frequency array
        int[] farr = new int[26];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }

        // 5. Execute the solution and print the result
        System.out.println(solution(words, farr, score, 0));
    }

    // Solution method signature
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx==words.length)
            return 0;
        //  if word not included
        int sno= solution(words, farr, score, idx+1);

        // if words included then check if it can be included or not
        String word=words[idx];
        boolean flag=true;
        int sword=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(farr[ch-'a']==0){
                flag=false;
            }
            farr[ch-'a']--;
            sword+=score[ch-'a'];
        }
        int syes=0;
        if(flag){
            syes=sword+solution(words, farr, score, idx+1);
        }
        // backtrack and increase farr values while backtracking
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            farr[ch-'a']++;
        }
        return Math.max(syes,sno);
    }
}
