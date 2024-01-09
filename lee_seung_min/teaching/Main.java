package lee_seung_min.teaching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static ArrayList<String> words;
    private static boolean[] can_use_words;
    private static int max = Integer.MIN_VALUE;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        can_use_words = new boolean[26];
    }

    private static void process() {
        char[] base_word = { 'a', 'n', 't', 'i', 'c' };
        for (char word : base_word) {
            can_use_words[word - 'a'] = true;
        }
        if (K < 5) {
            max = 0;
        } else {
            backtracking(0, 0);
        }
    }

    private static void backtracking(int alpha, int len) {
        if (len == K-5) {
            int count = 0;
            for (int i = 0; i < N; i++) { // 단어 하나씩 확인
                boolean read = true;
                for (int j = 0; j < words.get(i).length(); j++) {
                    if (!can_use_words[words.get(i).charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read)
                    count++;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (can_use_words[i] == false) {
                can_use_words[i] = true;
                backtracking(i, len + 1);
                can_use_words[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력하기
        init();
        // 프로세스 진행
        process();
        // 정답 출력
        System.out.println(max);
    }
}