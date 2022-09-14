import java.io.*;

/**
 * [레벨 1] 부족한 금액
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public long solution(int price, int money, int count) {
        long result = money;
        for(int i = 1; i <= count; i++) result -= price * i;
        return result < 0 ? Math.abs(result) : 0;
    }
}
