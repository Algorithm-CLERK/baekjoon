package lee_seung_min.min_max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;
    private static StringBuilder sb = new StringBuilder();

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // 최소 최대 찾기
        find_min_max();
    }

    private static void find_min_max() {
        int min = 10000000;
        int max = -1000000;
        for (int number : numbers) {
            if (min > number) {
                min = number;
            }
            if (max < number) {
                max = number;
            }
        }
        sb.append(min).append(" ").append(max);
    }
    
    public static void main(String[] args) throws IOException{
        // 입력하기
        init();
        // 정답 출력
        System.out.println(sb);
    }
    
}
