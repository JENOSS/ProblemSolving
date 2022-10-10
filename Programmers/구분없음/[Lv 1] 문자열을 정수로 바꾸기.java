import test.Test;
import test.Test2;

/**
 * [Lv 1] 문자열을 정수로 바꾸기
 *
 */

public class Main {


    public static void main(String[] args) {
    }

    public int solution(String s) {
        if(!Character.isDigit(s.charAt(0))){
            int i = Integer.parseInt(s.substring(1));

            if(s.charAt(0) == '-'){
                return -i;
            }else{
                return i;
            }
        }else{
            return Integer.parseInt(s);
        }
    }


}


