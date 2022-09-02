import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * [HackerRank] Climbing the Leaderboard
 *
 *  투포인터로 해결
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> distinctRanked = ranked.stream().distinct().collect(Collectors.toList());

        List<Integer> ans = new ArrayList();
        int rPoint = distinctRanked.size() - 1;

        for(int pPoint = 0; pPoint < player.size(); pPoint++){
            int rank = 1;

            while(rPoint >= 0){
                int p = player.get(pPoint);
                int r = distinctRanked.get(rPoint);

                if(p < r){
                    rank = rPoint + 2;
                    break;
                }else if (p > r){
                    rPoint--;
                }else{
                    rank = rPoint + 1;
                    break;
                }
            }

            ans.add(rank);
        }


        return ans;
    }

}


}
