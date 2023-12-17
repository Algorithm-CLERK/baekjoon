package lee_seung_min.escape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int R;
    private static int C;
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static char[][] map;
    private static int[][] waterTime;
    private static int[][] check;
    private static Queue<Point> q = new LinkedList<>();
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        waterTime = new int[R + 1][C + 1];
        check = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j + 1] = str.charAt(j);
                if (map[i][j + 1] == 'S') {
                    startX = i;
                    startY = j + 1;
                }
                if (map[i][j + 1] == 'D') {
                    endX = i;
                    endY = j + 1;
                }
                if (map[i][j + 1] == '*') {
                    q.add(new Point(i, j + 1));
                }
            }
        }
    }

    private static void waterBFS() {
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isIn(nx, ny)) {
                    if (waterTime[nx][ny] == 0 && map[nx][ny] == '.') {
                        waterTime[nx][ny] = waterTime[x][y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        if (x >= 1 && y >= 1 && x <= R && y <= C)
            return true;
        return false;
    }

    private static void BFS() {
        Queue<Point> BFSq = new LinkedList<>();
        BFSq.add(new Point(startX, startY));
        while (!BFSq.isEmpty()) {
            int x = BFSq.peek().x;
            int y = BFSq.peek().y;
            BFSq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isIn(nx, ny))
                    continue;
                if (check[nx][ny] != 0)
                    continue;
                if (map[nx][ny] == 'X')
                    continue;
                if (waterTime[nx][ny] == 0 || waterTime[nx][ny] > check[x][y] + 1) {
                    check[nx][ny] = check[x][y] + 1;
                    BFSq.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기
        init();
        // 물 BFS 탐색 시작
        waterBFS();
        // 고슴도치 BFS 탐색 시작
        BFS();
        if (check[endX][endY] != 0) {
            System.out.println(check[endX][endY]);
        } else {
            System.out.println("KAKTUS");
        }
    }

}
