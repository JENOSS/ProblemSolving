import java.io.*;


/**
 * [카카오 인턴십] [Lv 2] 두 큐 합 같게 만들기
 *
 * 투 포인터 사용
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(new int[]{1,1}, new int[]{1,5}));
    }

    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;

        for(int q1 : queue1) sum1 += q1;
        for(int q2 : queue2) sum2 += q2;

        if(sum1 < sum2){
            return check(queue1, sum1, queue2, sum2);
        }else if(sum1 > sum2){
            return check(queue2, sum2, queue1, sum1);
        }else{
            return 0;
        }
    }

    public static int check(int[] queue1, long sum1, int[] queue2, long sum2){
        // queue1의 sum 이 더 작음
        // 두 큐를 하나로 만든다. 투 포인터 이용
        int[] queue = new int[queue1.length * 3];
        for(int i = 0; i < queue1.length; i++) queue[i] = queue1[i];
        for(int i = queue1.length; i < queue1.length * 2; i++) queue[i] = queue2[i - queue1.length];
        for(int i = queue1.length * 2; i < queue1.length * 3; i++) queue[i] = queue1[i - (queue1.length * 2)];

        // 두 합이 홀수면
        if( (sum1 + sum2) % 2 != 0) return -1;

        long target = (sum1 + sum2) / 2;

        int point1 = 0;
        int point2 = queue1.length;

        // 두 큐의 사이즈는 같으며 최대 교환은 length * 2이다.
        // queue1 + queue2 + queue1 과 같은 형태로 구현해야 테스트 가능
        int end = queue1.length * 3;
        for(int count = 0; count <= end; count++){
            if(sum1 == target) return count;

            if(sum1 > target){
                sum1 -= queue[point1++];
            }else{
                sum1 += queue[point2++];
            }
        }

        return -1;

    }
}
