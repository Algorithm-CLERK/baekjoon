package lee_seung_min.parentheses_value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static Stack<Character> stack = new Stack<>();
    private static char[] parentheses_value;
    private static boolean flag;
    private static int cnt;
    private static int answer;
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parentheses_value = br.readLine().toCharArray();
        flag = true;
        cnt = 1;
        answer = 0;
    }
    
    private static void process() {
        for(int i=0; i<parentheses_value.length; i++){
            char parenthesis = parentheses_value[i];
            if (parenthesis == '(') {
                stack.push(parenthesis);
                cnt *= 2;
            }
            if (parenthesis == '[') {
                stack.push(parenthesis);
                cnt *= 3;
            }
            if (parenthesis == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    return;
                }
                if (parentheses_value[i - 1] == '(') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 2;
            }
            if (parenthesis == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    return;
                }
                if (parentheses_value[i - 1] == '[') {
                    answer += cnt;
                }
                stack.pop();
                cnt /= 3;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기
        init();
        // 로직 수행
        process();
        // 정답 출력
        if (!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }
}
