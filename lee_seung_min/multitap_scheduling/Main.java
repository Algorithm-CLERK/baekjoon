package lee_seung_min.multitap_scheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N; // 멀티탭 구멍의 개수
    private static int K; // 전기 용품의 사용 횟수
    private static int[] order; // 사용 순서
    private static int answer; // 정답
    private static Set<Integer> multitap = new HashSet<Integer>(); // 현재 사용 중인 멀티탭

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    private static void process() {
        for (int i = 0; i < order.length; i++) {
            if (multitap.contains(order[i]))
                continue;
            if (multitap.size() < N) {
                multitap.add(order[i]);
                continue;
            }
            int num = findNum(i); // 제거할 가장 좋은 숫자를 고른다.
            multitap.remove(num);
            multitap.add(order[i]);
            answer++; // 무저건 멀티탭을 뽑아야한다.
        }
    }

    private static int findNum(int index) {
        int max = Integer.MIN_VALUE;
        for (int num : multitap) { // 멀티 탭에 꽃혀 있는 숫자들을 한 개 씩 확인한다.
            boolean flag = false;
            for (int i = index; i < order.length; i++) {
                if (num == order[i] && max <= i) {
                    flag = true;
                    max = i;
                    break;
                }
                if (num == order[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return num;
        }
        return order[max];
    }

    public static void main(String[] args) throws IOException{
        // 입력받기
        init();
        // 순차적으로 진행하기
        process();
        // 정답 출력하기
        System.out.println(answer);
    }
}