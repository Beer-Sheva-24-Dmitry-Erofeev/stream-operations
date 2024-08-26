package telran.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamTasks {

    public static int[] shuffle(int[] arr) {
        return new Random()
            .ints(0, arr.length)
            .distinct()
            .limit(arr.length)
            .map(i -> arr[i])
            .toArray();
    }

    public static int[] shuffleMyVersion(int[] arr) {
        // Involves Fisher-Yates shuffle algorithm
        // It's incorrect HW due to not being a single pipeline
        Random random = new Random();
        return IntStream
                .range(0, arr.length)
                .map(i -> {
                    int j = i + random.nextInt(arr.length - i);
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    return arr[i];
                })
                .toArray();
    }
}
