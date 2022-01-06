package com.exmaple.ps;

import java.util.PriorityQueue;

/*
 *  1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
 *  2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
 *  3. 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
 *
 *  PriorityQueue<>() = 낮은 숫자 우선
 *  PriorityQueue<>(Collections.reversOrder()) = 높은 숫자 우선
 */
public class Main {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{0 , 1, 2, 3},1));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length; i++){
            pq.add(scoville[i]);
        }

        while(!pq.isEmpty()){
            Integer value = pq.poll();
            Integer nextValue = pq.poll();

            if(value < K){
                if(nextValue == null) {
                    answer = -1;
                    break;
                }
                pq.add(value + nextValue * 2);
                answer++;
            }
        }


        return answer;
    }
}
