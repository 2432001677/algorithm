package sort;

import base.MaxPQ;
import base.Tools;

import java.util.List;

public class Sort<T extends Comparable<T>> {
    private final Tools<T> tools = new Tools<>();

    public void shellSort(List<T> list) {
        int N = list.size();
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && tools.less(list.get(j), list.get(j - h)); j -= h)
                    tools.exchange(list, j, j - h);
            h /= 3;
        }
    }

    public void mergeSort(List<T> list) {

    }

    public void quickSort(List<T> list, int lo, int hi) {
        if (hi < lo + 10) {
            new SimpleSort<T>().insertSort(list);
            return;
        }
        int i = lo, j = hi + 1;
        while (true) {
            while (tools.less(list.get(++i), list.get(lo))) if (i == hi) break;
            while (tools.less(list.get(lo), list.get(--j))) if (j == lo) break;
            if (i >= j) break;
            tools.exchange(list, i, j);
        }
        tools.exchange(list, lo, j);
        quickSort(list, lo, j - 1);
        quickSort(list, j + 1, hi);
    }

    public void heapSort(List<T> list) {
        MaxPQ<T> maxPQ = new MaxPQ<>(10);
        list.forEach(maxPQ::insert);
        int i = 0;
        while (!maxPQ.isEmpty())
            list.set(i++, maxPQ.delMax());
    }

    public static void main(String[] args) {
        List<Integer> integers = Tools.unsortedList();
//        new Sort<Integer>().shellSort(integers);
//        new Sort<Integer>().quickSort(integers, 0, integers.size() - 1);
        new Sort<Integer>().heapSort(integers);
        integers.forEach(System.out::println);
    }
}
