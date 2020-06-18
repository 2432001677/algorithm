package search;

import base.Tools;

public class BST<T extends Comparable<T>> {
    private final Tools<T> tools = new Tools<>();
    private Node root;
    private int N = 0;

    private class Node {
        private final T data;
        private Node left = null;
        private Node right = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public int getN() {
        return this.N;
    }

    private void pre(Node node) {
        System.out.println(node.data);
        if (node.left != null)
            pre(node.left);
        if (node.right != null)
            pre(node.right);
    }

    private void post(Node node) {
        if (node.left != null)
            post(node.left);
        if (node.right != null)
            post(node.right);
        System.out.println(node.data);
    }

    private void mid(Node node) {
        if (node.left != null)
            mid(node.left);
        System.out.println(node.data);
        if (node.right != null)
            mid(node.right);
    }

    public void preTraversal() {
        if (N > 0)
            pre(this.root);
    }

    public void postTraversal() {
        if (N > 0)
            post(this.root);
    }

    public void midTraversal() {
        if (N > 0)
            mid(this.root);
    }

    public boolean find(T data) {
        Node node = this.root;
        while (node != null) {
            if (data.equals(node.data))
                return true;
            node = tools.less(data, node.data) ? node.left : node.right;
        }
        return false;
    }

    public T min() {
        Node node = this.root;
        while (node.left != null)
            node = node.left;
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    public T max() {
        Node node = this.root;
        while (node.right != null)
            node = node.right;
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    public void put(T data) {
        if (this.root == null)
            this.root = new Node(data);
        Node node = this.root;
        while (node != null) {
            if (data.equals(node.data))
                break;
            if (tools.less(data, node.data)) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new Node(data);
                    this.N++;
                }
            } else {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new Node(data);
                    this.N++;
                }
            }
        }
    }
}
