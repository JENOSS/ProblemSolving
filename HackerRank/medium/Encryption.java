import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * [medium] Encryption
 *
 * 문자열 처리 Math.sqrt / Math.floor / Math.ceil 복기
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print(encryption("chillout"));
    }

    public static String encryption(String s) {
        // Write your code here
        s = s.replaceAll(" ", "");
        int L = s.length();
        int row = (int) Math.floor(Math.sqrt(L));
        int column = (int) Math.ceil(Math.sqrt(L));

        if(row * column < L) row = column;

        String[] arrayString = new String[row];

        int start = 0;
        int end = column;
        for(int i = 0; i < row; i++){
            arrayString[i] = s.substring(start, end);
            start = end;
            end = end + column > L ? L : end + column;
        }

        StringBuilder[] resultString = new StringBuilder[column];
        for(int i = 0; i < column; i++) resultString[i] = new StringBuilder();

        for(String st : arrayString){
            for(int i = 0; i < st.length(); i++){
                resultString[i].append(st.charAt(i));
            }
        }

        StringBuilder finalString = new StringBuilder();
        for(StringBuilder sb : resultString){
            finalString.append(sb).append(" ");
        }

        return finalString.toString();
    }


}
