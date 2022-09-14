import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * [medium] Organizing Containers of Balls
 *
 * Container 별 보유 가능 개수 == 각 타입별 공의 개수 (각 컨테이너가 보유 가능한 사이즈 3,3,2 와 각 타입별 수 2,3,2 같은 느낌)
 * 각 행 별로 더한것과 각 열 별로 더한것을 각각 오름차순으로 정렬해서 비교하는 방식으로 가능
 **/

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        if(container.size() == 1) return "Possible";

        HashMap<Integer, Long> eachValueCount = new HashMap<>();
        HashMap<Long, Integer> eachSizeOfContainer = new HashMap<>();

        for(List<Integer> con : container){
            long totalValueCount = 0;

            for(int i = 0; i < con.size(); i++){
                long v = con.get(i);
                totalValueCount += v;
                eachValueCount.put(i, eachValueCount.getOrDefault(i, 0L) + v);
            }

            eachSizeOfContainer.put(totalValueCount, eachSizeOfContainer.getOrDefault(totalValueCount, 0) + 1);
        }

        for(long v : eachValueCount.values()){
            if(eachSizeOfContainer.getOrDefault(v, 0) == 0) return "Impossible";

            eachSizeOfContainer.put(v, eachSizeOfContainer.get(v) - 1);
        }

        return "Possible";
    }
}
