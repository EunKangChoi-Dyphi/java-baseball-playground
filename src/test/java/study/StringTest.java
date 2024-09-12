package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*
    * 요구사항1
    * -  "1,2"를 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습테스트 구현한다.
    * -  "1" 을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 대한 학습테스트를 구현한다.
    * */
    @Test
    void separateMyself() {
        String inputString = "1,2";
        String[] testResult = inputString.split(",");
        String[] expectedResult = new String[]{"1", "2"};
        assertThat(testResult).isEqualTo(expectedResult);


        inputString = "1";
        testResult = inputString.split(",");
        expectedResult = new String[]{"1"};
        assertThat(testResult).isEqualTo(expectedResult);
    }

    @Test
    void separateHint() {
        String inputString = "1,2";
        String[] testResult = inputString.split(",");
        assertThat(testResult).contains("1", "2");

        inputString = "1";
        testResult = inputString.split(",");
        assertThat(testResult).containsExactly("1");
    }

    /*
    * 요구사항 2
    * "(1,2)" 값이 주어졌을 때 String의 subString() 메소드를 활용해 ()을 제거하고 "1,2" 를 반환하도록 구현한다.
    * */
}
