package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Set Collection에 대한 학습테스트
public class SetCollectionTest {

    private Set<Integer> numbers;


    /**
     * 요구사항 1: Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
     */
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1: Set size 테스트(스스로)")
    void setSizeMyself() {
        int expectedTestResult = 3; // 1,2,3
        int testResult = numbers.size();
        assertThat(testResult).isEqualTo(expectedTestResult);
    }

    /**
     * 요구사항 2
     *
     * Set의 contains() 메소드를 활용해 1,2,3 의 값이 존재하는지 확인하는 학습테스트를 구현하려고한다.
     * 구현하고보니 다음과 같이 중복 코드가 계속 해서 발생한다.
     * Junit의 ParameterizedTest를 활용하여 중복코드를 제거해본다.
     *
     *
     * ```java
     *  @Test
     *  void contains() {
     *         assertThat(numbers.contains(1)).isTrue();
     *         assertThat(numbers.contains(2)).isTrue();
     *         assertThat(numbers.contains(3)).isTrue();
     *  }
     * ```
     */


    @ParameterizedTest
    @ValueSource( ints = {1, 2, 3})
    @DisplayName("요구사항 2: Set의 contains() 메소드를 활용하여 1,2,3의 값이 존재하는지를 확인하는 테스트 (스스로)")
    void containsMyself(int n) {
        assertTrue(numbers.contains(n));
    }

    /**
     * 요구사항 3
     *
     * 요구사항 2는 contains 메소드 결과값이 true인 경우에만 테스트 가능하다.
     * 입력값에 따라 결과가 다른 경우에 대한 테스트도 가능하도록 구현한다.
     * 예를 들어
     * - 1,2,3 값은 contains 메소드 실행결과 true
     * - 4,5 값을 넣으면 false가 반환되는 테스트 케이스를 구현한다.
     *
     */
    @ParameterizedTest
    @MethodSource("range")
    @DisplayName("요구사항 3: Set contains() 메소드를 활용하여 1,2,3 은 true를. 4,5는 false 로 나타내기 (스스로)")
    void contains2Myself(int n) {
        boolean result = numbers.contains(n);
        if(n >= 1 && n <= 3) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    static IntStream range() {
        return IntStream.range(1, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false",
    }, delimiter = ':')
    void contains2Hint(int n, boolean expected) {
        boolean actualValue = numbers.contains(n);
        assertEquals(expected, actualValue);
    }


}
