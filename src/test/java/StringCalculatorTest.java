import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @Test
    @DisplayName("여러가지 input 테스트")
    void testSplit() {
        String[] result = cal.split("1");
        assertArrayEquals(new String[]{"1"}, result);

        result = cal.split("");
        assertArrayEquals(new String[]{""}, result);

        result = cal.split(null);
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    @DisplayName(", 구분자로 split -> String[]")
    void testSplitWhenComma() {
        String[] result = cal.split("1,2,3");
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new String[]{"1", "2", "3"}, result);

        result = cal.split("1,2,3,4");
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, result);
    }

    @Test
    @DisplayName("newLine split -> String[]")
    void testSplitWhenNewLine() {
        String[] result = cal.split("1\n2\n3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName(", 와 newLine split -> String[]")
    void testSplitWhenNewLindAndComma() {
        String[] result = cal.split("1\n2,3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("String[] -> int[]")
    void testToInt() {
        int[] result = cal.toInt(new String[]{"1", "2"});
        assertArrayEquals(new int[]{1, 2}, result);

        //경계값 테스트
        result = cal.toInt(new String[]{});
        assertArrayEquals(new int[]{}, result);

        result = cal.toInt(null);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    @DisplayName("int[] -> 숫자 합")
    void intArraySum() {
        int[] intArr = new int[]{1, 2, 3};
        int sum = cal.sumIntArr(intArr);
        assertEquals(sum, 6);

        sum = cal.sumIntArr(new int[]{});
        assertEquals(sum, 0);

        sum = cal.sumIntArr(null);
        assertEquals(sum, 0);
    }

    @Test
    @DisplayName("문자열 -> 숫자합")
    void strTest() {
        String str = "1,2,3,4";
        int numberSum = cal.calculate(str);
        assertEquals(numberSum, 10);

        str = "1,2\n3,4\n5";
        numberSum = cal.calculate(str);
        assertEquals(numberSum, 15);
    }
}
