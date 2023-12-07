package find_binary_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int TC;
    private static StringBuilder sb = new StringBuilder();
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            int n = Integer.parseInt(br.readLine());
            // 이진수 1위치 구하기
            process(n);
        }
    }

    private static void process(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 1)
                sb.append(cnt).append(" ");
            num /= 2;
            cnt++;
        }
        sb.append("\n");
    }
    

    public static void main(String args[]) throws IOException {
        // 입력 받기
        init();
        // 결과 출력
        System.out.println(sb);
    }
    
}
