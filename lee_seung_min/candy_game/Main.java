package lee_seung_min.candy_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static char[][] map;
    private static int answer;
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };
    

    public static void main(String[] args) throws IOException {
        init();
        process();
        System.out.println(answer);
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            map[i] = line;
        }
        answer = 0;
    }

    private static void process() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!isOut(i + dx[k], j + dy[k])) {
                        char c = map[i][j];
                        map[i][j] = map[i + dx[k]][j + dy[k]];
                        map[i + dx[k]][j + dy[k]] = c;

                        int maxNum = countMaxNum();
                        answer = Math.max(answer, maxNum);

                        char d = map[i][j];
                        map[i][j] = map[i + dx[k]][j + dy[k]];
                        map[i + dx[k]][j + dy[k]] = d;
                    }
                    
                }
            }
        }
    }

    private static int countMaxNum() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            char c = map[i][0];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (c == map[i][j]) {
                    cnt++;
                } else {
                    num = Math.max(num, cnt);
                    cnt = 1;
                    c = map[i][j];
                }
            }
            num = Math.max(num, cnt);
        }
        
        for (int i = 0; i < N; i++) {
            char c = map[0][i];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (c == map[j][i]) {
                    cnt++;
                } else {
                    num = Math.max(num, cnt);
                    cnt = 1;
                    c = map[j][i];
                }
            }
            num = Math.max(num, cnt);
        }
        return num;
    }
    
    private static boolean isOut(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return true;
        return false;
    }

}
