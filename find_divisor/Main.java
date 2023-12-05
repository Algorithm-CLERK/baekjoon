package find_divisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static int answer;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        // 입력 받기
        init();
        // 약수 찾기
        process();

        // 정답 출력
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
    
    private static void process() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
            if (count == K) {
                sb.append(i);
                return;
            }
        }
        sb.append(0);
        return;
    }

}
