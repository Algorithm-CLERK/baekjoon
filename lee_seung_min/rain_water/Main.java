package lee_seung_min.rain_water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int H;
    private static int W;
    private static int[] block;
    private static int answer;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
    }
    
    private static void process() {
        for (int height = 1; height <= H; height++) {
            int start_point = -1;
            int end_point = -1;
            for (int i = 0; i < block.length; i++) {
                if (block[i] >= height) {
                    if (start_point == -1) {
                        start_point = i;
                        end_point = i;
                    } else {
                        end_point = i;
                        answer += end_point - start_point - 1;
                        start_point = i;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        // 입력하기
        init();
        // 물 양 확인하기
        process();
        // 정답 출력
        System.out.println(answer);
    }
}
