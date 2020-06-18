package search;

import base.Tools;

import java.util.Arrays;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Tools.unsortedList().forEach(bst::put);
//        bst.preTraversal();
//        bst.postTraversal();
//        bst.midTraversal();
//        System.out.println(bst.find(9));
//        System.out.println(bst.min());
//        System.out.println(bst.max());
        List<Integer> list = Arrays.asList(83, 4, 108, 15, 52, 90, 35, 78, 24, 14, 87, 76, 116, 102, 63, 71, 118, 40, 62, 13);

    }
}
