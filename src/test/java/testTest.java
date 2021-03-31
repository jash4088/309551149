
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class testTestTest {
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 2, 3}, new int[]{4, 3, 4, 5}),
                Arguments.of(new int[]{-1, -4, -2, 0}, new int[]{-4, -2, -1, 0}),
                Arguments.of(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{-1}, new int[]{-1}),
                Arguments.of(new int[]{2147483647, 0, -2147483648}, new int[]{-2147483648, 0, 2147483647})
        );
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void Runtest(int[] input, int[] answer) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int index = 0;
        int i = 0, j = 0;
        int[] result = new int[input.length];

        while(i < result.length)
        {
            q.add(input[i++]);
        }

        while(j < result.length)
        {
            result[j++] = q.remove();
        }

        assertArrayEquals(answer, result);
    }

    @Test
    void Expection_IllegalArgumentException()
    {
        Exception exc = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>( 2);
        });
    }

    @Test
    void Expection_NullPointerException()
    {
        Exception exc = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>( 1);
            q.add(null);
        });
    }

    @Test
    void Expection_NoSuchElementException()
    {
        Exception exc = assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<String> q = new PriorityQueue<String>( 1);
            q.remove();
            q.remove();
        });
    }


}