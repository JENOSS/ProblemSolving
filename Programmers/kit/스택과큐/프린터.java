package com.exmaple.ps;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3}, 0));
    }


    public static int solution(int[] priorities, int location) {
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < priorities.length ; i++){
            q.add(i);
        }

        while (!q.isEmpty()){
            int currentIdx = q.poll();
            int currentPriority = priorities[currentIdx];
            if(check(q,priorities,currentPriority)){
                cnt++;
                if(currentIdx == location) break;
            }else{
                q.add(currentIdx);
            }
        }

        return cnt;
    }

    public static boolean check(Queue<Integer> q, int priorities[], int currentPriority){

        for(Integer i : q){
            if(priorities[i] > currentPriority) return false;
        }

        return true;
    }
}
