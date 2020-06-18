package base;


import java.util.ArrayList;
import java.util.List;

public class MaxPQ<T extends Comparable<T>> {
    private final List<T> list = new ArrayList<>();
    private final Tools<T> tools = new Tools<>();
    private int length;

    MaxPQ() {
        this.length = 0;
        this.list.add(null);
    }

    public MaxPQ(int max) {
        this.length = max;
        this.list.add(null);
    }

    public T max() {
        return list.get(1);
    }

    public void insert(T v) {
        if (this.list.size() < this.length + 1) {
            this.list.add(v);
            this.swim();
        }
    }

    public T delMax() {
        T res = this.list.get(1);
        tools.exchange(this.list, 1, this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        this.sink();
        return res;
    }

    public boolean isEmpty() {
        return this.list.size() <= 1;
    }

    public int size() {
        return this.list.size() - 1;
    }

    private void swim() {
        int hi = this.list.size() - 1;
        while (hi > 1) {
            if (tools.less(this.list.get(hi / 2), this.list.get(hi)))
                tools.exchange(list, hi / 2, hi);
            hi /= 2;
        }
    }

    private void sink() {
        int li = 1;
        while (2 * li < this.list.size()) {
            int max;
            if (li * 2 + 1 >= this.list.size())
                max = li * 2;
            else
                max = tools.less(this.list.get(li * 2), this.list.get(li * 2 + 1)) ? li * 2 + 1 : li * 2;
            if (tools.less(this.list.get(li), this.list.get(max))) {
                tools.exchange(this.list, li, max);
                li = max;
            } else break;
        }
    }
}
