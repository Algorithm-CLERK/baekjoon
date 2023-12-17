package insert_operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int N;
    private static int[] num;
    private static int[] opertator = new int[4];

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opertator[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dfs(int n, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, n);
            MIN = Math.min(MIN, n);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opertator[i] > 0) {
                opertator[i]--;
                switch (i) {
                    case 0:
                        dfs(n + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(n - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(n * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(n / num[idx], idx + 1);
                        break;
                    default:
                        break;
                }
                opertator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 입력 받기
        init();
        // DFS 탐색 시작
        dfs(num[0], 1);
        // 정답 출력
        System.out.println(MAX);
        System.out.println(MIN);
    }
}