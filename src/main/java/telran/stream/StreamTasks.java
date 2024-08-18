package telran.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamTasks {

    public static int[] shuffle(int[] arr) {
        Random random = new Random();
        return IntStream
                .range(0, arr.length)
                .map(i -> {
                    // Fisher-Yates shuffle algorithm
                    int j = i + random.nextInt(arr.length - i);
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    return arr[i];
                })
                .toArray();
    }
}
