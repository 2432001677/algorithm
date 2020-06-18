package sort;

import base.Tools;

import java.util.List;

public class SimpleSort<T extends Comparable<T>> {
    private final Tools<T> tools = new Tools<>();

    public void selectedSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++)
                if (tools.less(list.get(j), list.get(minIndex)))
                    minIndex = j;
            tools.exchange(list, i, minIndex);
        }
    }

    public void insertSort(List<T> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = i; j > 0; j--)
                if (tools.less(list.get(j), list.get(j - 1)))
                    tools.exchange(list, j, j - 1);
                else
                    break;
    }

    public static void main(String[] args) {
        List<Integer> integers = Tools.unsortedList();
//        new SimpleSort<Integer>().selectedSort(integers);
        new SimpleSort<Integer>().insertSort(integers);
        integers.forEach(System.out::println);
    }
}
