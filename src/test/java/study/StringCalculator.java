package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * [ 문자열 계산기 ]
 * 다음 요구사항은 JUnit 을 활용해 단위테스트 코드를 추가해 구현한다.
 *
 * 요구사항
 * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야한다.
 * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력값에 따라 계산 순서가 결정된다.
 *   즉, 수학에서는 곱셈/나눗셈 이 덧셈/뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 *
 * - 예를들어 "2 + 3 * 4 / 2" 와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야한다.
 *  (2 + 3) * 4 / 2 => (5*4) / 2 => 20/ 2 => 10
 *
 *  case 1) 화이트스 페이스가 있는경우
 *  ex) "2 + 3 * 4 / 2"
 *  ex) "3  " => 3 으로 리턴
 *
 *  [advanced]
 *  ex) "2+ 3 * 4/2"  (일부분만 있는 경우) => "2 + 3 * 4 / 2"
 *  ex) "3 4 + 5" => "34 + 5" 로 리턴
 *
 *  case 2) 화이트 스페이스가 없는경우
 *  ex) 3+4 => "3 + 4"
 *  ex) 3
 *
 *
 * case 3) 숫자와 연산자가 아닌 계산할 수 없는 문자열이 들어있는 경우
 * ex) "가 + abc"
 * => NaN 을 리턴하거나 예외를 발생시킨다.
 * ex) ""
 * => 인자가 없으므로
 *
 *
 * case 4) 잘못된 식
 * => 잘못된 식으로 에러를 발생시킨다.
 * ex) "2 + +"
 */
public class StringCalculator {
    private String inputStr;
    private int result;
    private Set<String> operators;

    @BeforeEach()
    void initialize() {
        operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("%");

        // 초기화
        result = 0;
        inputStr = "";
    }

    private String[] convertStringArr(String inputStr) {
        // 1. 입력문자열에 화이트스페이스들을 모두 제거한다.
        //        String strRemovedWhiteSpaces = inputStr.replace(" ", "");
        // 2. white-space 를 기준으로 split 시켜서 문자열 배열로 리턴한다.
        return inputStr.split(" ");
    }

    private boolean isOperator (String element) {
        return operators.contains(element);
    }
    private int calculateInputStr(String[] strArr) {
        String operator = "";
        for(int i = 0 ; i < strArr.length ; i++) {
            // 현재값
            String curr = strArr[i];

            if(isOperator(curr)) {
                operator = curr;
                continue;
            }

            int currInt = Integer.parseInt(curr);
            if(i == 0){
                result = result + currInt;
                continue;
            }

            switch(operator) {
                case "+":
                    result = result + currInt;
                    break;
                case "-":
                    result = result - currInt;
                    break;
                case "*":
                    result = result * currInt;
                    break;
                case "/":
                    result = result / currInt;
                    break;
                case "%":
                    result = result % currInt;
                    break;
            }

        }
        return result;
    }


    @Test
    @DisplayName("문자열 '2 + 3 * 4 / 2' 의 결과는 10 이다")
    void test1() {

        inputStr = "2 + 3 * 4 / 2";
        String[] strArr =convertStringArr(inputStr);

        int result = calculateInputStr(strArr);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("문자열 '3' 의 결과는 3이다")
    void test2() {
        inputStr = "3";
        String[] strArr =convertStringArr(inputStr);

//        String[] expectedArr = new String[]{"3"};
//        assertThat(strArr).isEqualTo(expectedArr);

        int result = calculateInputStr(strArr);
        assertThat(result).isEqualTo(3);
    }


//    void clear() {
//        // 결과값을 0 으로 초기화
//        result = 0;
//
//        // 리스트를 빈 배열로 초기화
//        chars.clear();
//
//    }
//    @AfterEach()
//    void tearDown() {
//
//
//        // 리스트와 결과를 다시 초기값으로 되돌린다.
//        clear();
//    }


}
