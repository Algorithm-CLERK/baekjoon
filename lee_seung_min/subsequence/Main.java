package lee_seung_min.subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int S;
    private static int[] arr;
    private static int answer;
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
    }

    private static void process() {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while (start <= N && end <= N) {
            if (total >= S && min > end - start)
                min = end - start;
            if (total < S) {
                total += arr[end];
                end++;
            } else {
                total -= arr[start];
                start++;
            }
        }
        if (min != Integer.MAX_VALUE)
            answer = min;
    }
    public static void main(String[] args) throws IOException{
        // 입력하기
        init();
        // 최소 길이 구하기
        process();
        // 정답 출력
        System.out.println(answer);
    }
}
