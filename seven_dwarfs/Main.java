package seven_dwarfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] nineDwarfs = new int[9];
    private static int sum = 0;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            nineDwarfs[i] = Integer.parseInt(br.readLine());
            sum += nineDwarfs[i];
        }
    }

    private static void process() {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - nineDwarfs[i] - nineDwarfs[j] == 100) {
                    nineDwarfs[i] = 0;
                    nineDwarfs[j] = 0;
                    return;
                }
            }
        }
    }

    private static void answer() {
        for (int i = 2; i < 9; i++) {
            sb.append(nineDwarfs[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기
        init();
        // 난쟁이 찾기
        process();
        // 오릅차순 정렬
        Arrays.sort(nineDwarfs);
        // 정답 출력
        answer();
    }
}
