package lee_seung_min.prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int M;
    private static int N;
    private static boolean[] primeNumber = new boolean[10001];
    private static int sum;
    private static int minPrimeNumber;
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        for (int i = 2; i < primeNumber.length; i++) {
            primeNumber[i] = true;
        }
        sum = 0;
        minPrimeNumber = 0;
    }

    private static void process() {
        for (int i = 2; i * i <= 10000; i++) {
            if (primeNumber[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    primeNumber[j] = false;
                }
            }
        }
    }
    
    private static void answer() {
        for (int i = M; i <= N; i++) {
            if (primeNumber[i]) {
                minPrimeNumber = i;
                break;
            }
        }
        for (int i = M; i <= N; i++) {
            if (primeNumber[i]) {
                sum += i;
            }
        }
        if (sum == 0 && minPrimeNumber == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(minPrimeNumber);
    }
    
    public static void main(String[] args) throws IOException{
        init();
        process();
        answer();
    }
}
