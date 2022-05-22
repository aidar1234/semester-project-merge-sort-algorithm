package sortAlgorithms;

public class LinkedList {

    private Node head;

    public LinkedList(LinkedList linkedList) {
        if (linkedList.head == null) {
            this.head = null;
        }
        Node temp = linkedList.head;
        head = new Node(temp.value);
        Node current = head;
        while (temp.next != null) {
            current.next = new Node(temp.next.value);
            current = current.next;
            temp = temp.next;
        }
    }

    public LinkedList() {
        this.head = null;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return  value + ", " + next;
        }
    }

    public void sort() {
        if (head == null) {
            return;
        }
        head = mergeSort(head);
    }

    private Node sortedMerge(Node left, Node right) {
        Node result;

        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.value <= right.value) {
            result = left;
            result.next = sortedMerge(left.next, right);
        }
        else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    private Node mergeSort(Node node) {

        if (node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(node);

        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node getMiddle(Node node) {

        if (node == null)
            return node;

        Node fastPtr = node.next;
        Node slowPtr = node;

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if (fastPtr != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }
        return slowPtr;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = null;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    @Override
    public String toString() {
        return "[" + head + "]";
    }
}
