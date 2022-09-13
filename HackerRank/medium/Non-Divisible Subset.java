import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [medium] Non-Divisible Subset
 *
 * 2개를 더한 값이 k로 나누어 떨어지지 않는 S의 부분 집합 중 가장 큰 사이즈
 *
 * (A + B) % K == 0 이 되는 경우를 피하면된다.
 * ( (A % K) + (B % K) ) % K == 0
 * 각 괄호를 a,b 라고 할 때 a + b가 K가 되면 안 됨
 * ex) k == 4 일 때 0 + 4, 1 + 3, 2 + 2 는 불가
 *
 * 따라서 각 대응 되는 것 중 큰 값을 가져다 쓰자.
 *
 * 주의)
 *  - a 나 b가 0 일 경우 0에 해당하는 수가 많아도 1개만 가능
 *  - k 가 짝수라면 k / 2에 해당하는 수가 많아도 1개만 가능
 **/

public class Main {

    public static void main(String[] args) throws IOException {

    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        List<Integer> modS = new ArrayList<>();
        s.stream().forEach(v -> modS.add(v % k));

        int[] modArray = new int[k];
        modS.stream().forEach(v-> {
            modArray[v]++;
        });

        if(modArray[0] > 0) modArray[0] = 1;
        if(k % 2 == 0 && modArray[k / 2] > 0) modArray[k / 2] = 1;

        int max = 0;

        for(int i = 0 ; i <= k / 2; i++){
            if(i == 0){
                max += modArray[0];
            } else {
                max += Math.max(modArray[i], modArray[k - i]);
            }
        }

        return max;

    }


}
