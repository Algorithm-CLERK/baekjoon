package fibonacci_numbers_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] fibonacciNumber = new int[21];

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fibonacciNumber[0] = 0;
        fibonacciNumber[1] = 1;
    }

    private static void process() {
        for (int i = 2; i < 21; i++) {
            fibonacciNumber[i] = fibonacciNumber[i - 1] + fibonacciNumber[i - 2];
        }
    }

    public static void main(String[] args) throws IOException{
        // 입력 받기
        init();
        // 피보나치 수 찾기
        process();
        // 정답 출력
        System.out.println(fibonacciNumber[N]);
    }
}
