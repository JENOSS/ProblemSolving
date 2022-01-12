package com.exmaple.ps;

import java.util.*;

/*
 * 다시 풀어보기
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,3},{1,9},{2,6}}));
    }


    static class Job{
        int start,run;

        Job(int idx ,int[] job){
            this.start = job[0];
            this.run = job[1];
        }
    }

    public static int solution(int[][] jobs) {
        int time = 0;
        int hold = 0;
        int idx = 1;
        boolean flag = false;

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return Integer.compare(j1.run, j2.run);
            }
        });

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        pq.add(new Job(0,jobs[0]));

        while(!pq.isEmpty()){
            Job j = pq.poll();

            time += flag ? hold - j.start + j.run : j.run; // 최초 아님 : 최초
            hold = flag ? hold + j.run : j.start + j.run; // 최초 아님 : 최초

            while(idx < jobs.length && jobs[idx][0] <= hold){
                pq.add(new Job(idx, jobs[idx]));
                idx++;
            }

            if(idx < jobs.length && pq.isEmpty()){ // 텀 있는 경우
                pq.add(new Job(idx, jobs[idx]));
                flag = false;
                idx++;
            }else{
                flag = true;
            }

        }

        return time/jobs.length;
    }


}
