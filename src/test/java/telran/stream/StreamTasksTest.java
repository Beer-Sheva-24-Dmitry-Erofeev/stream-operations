package telran.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import static telran.stream.StreamTasks.shuffle;

public class StreamTasksTest {

    @Test
    void shuffleTest() {
        // Creating the array in a new and fancy way
        int[] original = IntStream.range(0, 11).toArray();
        // Making a shuffled copy of it
        int[] shuffled = shuffle(Arrays.copyOf(original, original.length));

        // Check that the shuffled array is different from the original
        assertFalse(Arrays.equals(original, shuffled));

        // Check that the two arrays contain the same elements
        int[] originalSorted = Arrays.copyOf(original, original.length);
        int[] shuffledSorted = Arrays.copyOf(shuffled, shuffled.length);
        Arrays.sort(originalSorted);
        Arrays.sort(shuffledSorted);
        assertArrayEquals(originalSorted, shuffledSorted);

        // Edge case - array with one element
        int[] singleElementArray = {1};
        assertArrayEquals(singleElementArray, shuffle(singleElementArray));

        // Edge case - array with all identical elements
        int[] identicalElementsArray = {7, 7, 7, 7, 7};
        assertArrayEquals(identicalElementsArray, shuffle(identicalElementsArray));
    }
}