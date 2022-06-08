import java.io.*;
import java.util.*;

/**
 [14888] [완전탐색] 연산자 끼워넣기
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1,nums[1]);
        sb.append(MAX).append('\n').append(MIN);
        System.out.println(sb);
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        nums = new int[N + 1];
        order = new int[N];
        operators = new int[5];

        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
    }

    static int N, MAX, MIN;
    static int[] nums, operators, order;

    static int calculator(int operand1, int operator, int operand2){
        switch (operator){
            case 1:
                return operand1 + operand2;
            case 2:
                return operand1 - operand2;
            case 3:
                return operand1 * operand2;
            default:
                return operand1 / operand2;
        }
    }

    // order[1...N-1]에 연산자들이 순서대로 저장될 것이다.
    // k-1 번째 연산자까지 계산한 결과가 value 이다.
    static void recFunc(int k, int value){
        if (k == N){ // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // value 를 정답에 갱신해준다.
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
        } else { // k 번째 연산자는 무엇을 선택할 것인가?
            // 4가지의 연사자들 중 뭘 쓸 것인지 선택하고 연산자를 계산한 후에 재귀호출하기
            for(int op = 1; op <= 4; op++){
                if(operators[op] >= 1){
                    operators[op]--;
                    recFunc(k + 1, calculator(value, op, nums[k + 1]));
                    operators[op]++;
                }
            }
        }
    }


}