package lee_seung_min.gcd_lcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int GCD;
    private static int LCM;
    public static void main(String[] args) throws IOException{
        // 입력하기
        init();
        // 최대 공약수 계산
        calculateGCD();
        // 최소 공배수 계산
        calculateLCM();
        // 정답 출력
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    private static void calculateGCD() {
        GCD = gcd(N, M);
        sb.append(GCD).append("\n");
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static void calculateLCM() {
        LCM = N * M / GCD;
        sb.append(LCM).append("\n");
    }
    
}