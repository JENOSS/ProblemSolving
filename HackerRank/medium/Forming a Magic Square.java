import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * [HakerRank] MacgicSquare
 *
 * 홀수 마방진 : x,y의 좌표를 -1 이동, 이동 시킨곳에 값 존재하면 변경 전 위치 값에 x+1, y
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());
        a.get(0).add(4);
        a.get(0).add(9);
        a.get(0).add(2);
        a.get(1).add(3);
        a.get(1).add(5);
        a.get(1).add(7);
        a.get(2).add(8);
        a.get(2).add(1);
        a.get(2).add(5);
        System.out.print(formingMagicSquare(a));
    }


    public static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = 72;
        int[][][] magicSquareCombinations = {
                { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
                { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
                { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
                { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } },
                { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
                { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
                { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
                { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
        };

        for (int i = 0; i < magicSquareCombinations.length; i++) {
            int modifyCost = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    modifyCost += Math.abs(s.get(j).get(k) - magicSquareCombinations[i][j][k]);
                }
            }
            minCost = Math.min(modifyCost, minCost);
        }
        return minCost;
    }

}
