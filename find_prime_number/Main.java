package find_prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int answer;

    private static void init() throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isPrime(Integer.parseInt(st.nextToken()));
        }
    }
    // 풀이 1
    // private static void isPrime(int num) {
    //     if (num < 2)
    //         return;
    //     for (int i = 2; i < num; i++) {
    //         if (num % i == 0)
    //             return;
    //     }
    //     answer++;
    //     return;
    // }

    // 풀이 2
    // private static void isPrime(int num) {
    //     if (num < 2)
    //         return;
    //     for (int i = 2; i <= num / 2; i++) {
    //         if (num % i == 0)
    //             return;
    //     }
    //     answer++;
    //     return;
    // }

    // 풀이 3
    private static void isPrime(int num) {
        if (num < 2)
            return;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return;
        }
        answer++;
        return;
    }

    public static void main(String[] args) throws IOException {
        // 입력하기
        init();
        // 정답 출력하기
        System.out.println(answer);
    }
}
