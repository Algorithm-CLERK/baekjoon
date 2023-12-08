package intelligent_train_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] numPeopleGotOff = new int[10];
    private static int[] numPeopleBoarded = new int[10];
    private static int answer;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numPeopleGotOff[i] = Integer.parseInt(st.nextToken());
            numPeopleBoarded[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        answer = -1;
        int numPeople = 0;
        for (int i = 0; i < 10; i++) {
            numPeople -= numPeopleGotOff[i];
            numPeople += numPeopleBoarded[i];
            if (answer < numPeople)
                answer = numPeople;
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력 받기
        init();
        // 계산하기
        process();
        // 정답 출력
        System.out.println(answer);
    }
}
