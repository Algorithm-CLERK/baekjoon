package lee_seung_min.sub_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] table;
    private static String S;
    private static String P;
    private static int answer;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();
        table = new int[P.length()];
        answer = 0;
    }

    private static void makeTable(String p) {
        int n = p.length();
        int index = 0;

        for (int i = 1; i < n; i++) {
            while (index > 0 && p.charAt(i) != p.charAt(index)) {
                index = table[index - 1];
            }
            if (p.charAt(i) == p.charAt(index)) {
                index++;
                table[i] = index;
            }
        }
    }

    private static void KMP(String s, String p) {
        makeTable(p);
        int sLength = s.length();
        int pLength = p.length();

        int index = 0;

        for (int i = 0; i < sLength; i++) {
            while (index > 0 && s.charAt(i) != p.charAt(index)) {
                index = table[index - 1];
            }
            if (s.charAt(i) == p.charAt(index)) {
                if (index == pLength - 1) {
                    index = table[index];
                    answer = 1;
                    return;
                } else {
                    index += 1;
                }
            }
        }
    }
    

    public static void main(String[] args) throws IOException{
        init();
        KMP(S, P);
        System.out.println(answer);
    }
}
