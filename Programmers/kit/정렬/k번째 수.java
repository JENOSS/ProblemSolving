import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = { {2, 5, 3},{4, 4, 1}, {1, 7, 3} };

        int[] sol = solution(array,commands);

        for(int i = 0 ; i < sol.length; i++){
            System.out.print(sol[i]+" ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0 ; i < commands.length ; i++){
            int start = commands[i][0] - 1;
            int last = commands[i][1];
            int index = commands[i][2] - 1;

            List<Integer> tempList = new ArrayList<>();
            for(int j = start ; j < last; j++){
                tempList.add(array[j]);
            }

            Collections.sort(tempList);

            answerList.add(tempList.get(index));
            tempList.clear();
        }

        int[] answerArray = new int[answerList.size()];
        for(int k = 0 ; k < answerList.size(); k++){
            answerArray[k] = answerList.get(k);
        }

        return answerArray;
    }
}
