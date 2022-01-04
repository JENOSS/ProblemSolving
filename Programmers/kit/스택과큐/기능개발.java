package com.exmaple.ps;
import java.util.Stack;

/*
   분모에 double 또는 float 캐스팅 안 하면 괄호 안에서 이미 정수로 떨어져서 Math.ceil 함수가 소용없다.
   ex) Math.ceil(70/30) = 2.0 Math.ceil(70/(float)30) = 3.0
 */

public class Main {

    public static void main(String[] args) {
        for(int i : solution(new int[]{95, 90, 80, 95, 99}, new int[]{2,1,2,1,1})){
            System.out.print(i+" ");
        }
    }


    public static int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();
        int day = 0;

        for(int i = 0 ; i < progresses.length ; i++){
            int value = (int) Math.ceil((100 - progresses[i]) / (float)speeds[i]);
            System.out.println(value);
            if(value <= day){
                int perDistribution = stack.pop() + 1;
                stack.push(perDistribution);
            }else{
                stack.push(1);
                day = value;
            }
        }

        int[] answer = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()){
            answer[i] = stack.pop();
            i--;
        }

        return answer;
    }

}
