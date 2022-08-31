import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

/**
 * [kit] [스택/큐] 같은 숫자는 싫어
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run(){
       System.out.print(solution(new int[]{1,1,3,3,0,1,1}));
    }

    public static int[] solution(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        int prev = -1;
        for(int next : arr){
            if(prev != next){
                ans.add(next);
                prev = next;
            }
        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = ans.get(i);

        return answer;
    }

}
