package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항 1: split 테스트 (스스로)")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1: 힌트참고")
    void separateHint() {
        String inputString = "1,2";
        String[] testResult = inputString.split(",");
        assertThat(testResult).contains("1", "2");

        inputString = "1";
        testResult = inputString.split(",");
        assertThat(testResult).containsExactly("1");
    }
    /*
    * 요구사항1
    * -  "1,2"를 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습테스트 구현한다.
    * -  "1" 을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 대한 학습테스트를 구현한다.
    * */

    @Test
    void separateMyself() {
        String inputString = "1,2";
        String[] expectedResult = new String[]{"1", "2"};
        String[] testResult = inputString.split(",");
        assertThat(testResult).isEqualTo(expectedResult);


        inputString = "1";
        expectedResult = new String[]{"1"};
        testResult = inputString.split(",");
        assertThat(testResult).isEqualTo(expectedResult);
    }

    /*
    * 요구사항 2
    * "(1,2)" 값이 주어졌을 때 String의 subString() 메소드를 활용해 ()을 제거하고 "1,2" 를 반환하도록 구현한다.
    * */
    @Test
    @DisplayName("요구사항 2: ( 와 ) 를 제거한 문자열을 추출하는 subString 활용한 테스트")
    void subString() {
        String inputString = "(1,2)";
        String expectedResult = "1,2";
        String testResult = inputString.substring(1,inputString.length() -1);
        assertThat(testResult).contains(expectedResult);
    }

    /**
     * 요구사항 3
     * - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정위치의 문자를 가져오는 학습테스트를 구현한다.
     * - String의 charAt() 메소드를 활용해 특정위치의 문자를 가져올 때 위치값을 벗어나면
     * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습테스트를 구현한다.
     * - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("요구사항 3 : 특정위치의 문자를 가져오는 테스트 (스스로)")
    char charAtMyself() {
        String inputString = "abc";
        int index = -1;
        char testResult = inputString.charAt(index);


        // 위치값을 벗어난 인덱스: 인덱스 < 0  &&  인덱스 >= inputString.length) 로 검색
        // 위치값을 벗어나면 StringIndexOutOfBoundsException 예외발생테스트
        if(index < 0 || index >= inputString.length()) {
            assertThat(testResult).isInstanceOf(StringIndexOutOfBoundsException.class);
            return testResult;
        }

        // 길이가 inputString.length 이하의 인덱스로 검색
        return testResult;
    }

    @Test
    @DisplayName("요구사항 3: 힌트참고")
    void charAtHint() {
        String inputString = "abc";
        int index = 4;
        char testResult;
        try {
            if(index < 0 && index >= inputString.length()) {
                throw new StringIndexOutOfBoundsException();
            }

            testResult = inputString.charAt(index);
            return;
        } catch (Exception error) {
            assertThatThrownBy( () -> {
                throw error;
            }).isInstanceOf(StringIndexOutOfBoundsException.class);
        }
    }


}
