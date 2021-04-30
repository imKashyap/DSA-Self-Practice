package practice.queue;

import practice.linkedlist.MyLinkedList.Node;

public class MyQueue<E> {
    private Node<E> head, rear;

    void enqueue(E e) {
        Node<E> toAdd = new Node<>(e);
        if (head == null)
            head = rear = toAdd;
        else {
            rear.next = toAdd;
            rear = rear.next;
        }

    }

    E dequeue() throws Exception {
        if (head == null) throw new Exception("Cannot remove from a Queue");
        Node<E> temp = head;
        head = head.next;
        if (head == null) rear = null;
        return temp.data;

    }

    public int size() {
        if (head == null)
            return 0;
        int count = 1;
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }


}
