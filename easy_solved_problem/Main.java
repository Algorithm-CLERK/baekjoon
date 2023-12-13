package easy_solved_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int A;
    private static int B;
    private static int[] cumulativeSum = new int[1001];

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        int flag = 1;
        for (int i = 1; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                cumulativeSum[flag] = cumulativeSum[flag - 1] + i;
                flag++;
                if (flag == 1001)
                    return;
            }
        }
    }

    private static void answer() {
        int answer = cumulativeSum[B] - cumulativeSum[A - 1];
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException{
        init();
        process();
        answer();
    }
}