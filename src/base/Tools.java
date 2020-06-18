package base;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tools<T extends Comparable<T>> {
    public static List<Integer> unsortedList() {
        return Arrays.asList(5, 30, 9, 1, 10, 43, 2);
    }

    public static List<Integer> randomList() {
        return Stream.generate(new Random()::nextInt).limit(20).map(integer -> integer & 127).collect(Collectors.toList());
    }

    public boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public void exchange(List<T> list, int first, int last) {
        T temp = list.get(first);
        list.set(first, list.get(last));
        list.set(last, temp);
    }
}
