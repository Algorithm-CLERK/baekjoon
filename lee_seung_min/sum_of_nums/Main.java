package lee_seung_min.sum_of_nums;

import java.io.*;

public class Main {
    private static long N;
    private static long answer;
    public static void main(String[] args) throws IOException {
        init();
        process();
        System.out.println(answer-1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        answer = 1;
    }

    private static void process() {
        while (answer * (answer + 1) / 2 <= N) {
            answer++;
        }
    }
}
