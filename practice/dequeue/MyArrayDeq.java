package practice.dequeue;

public class MyArrayDeq<E> {
    private Node<E> head, tail;
    public class Node<E> {
        public E data;
        public Node prev, next;

        public Node(E data) {
            this.data = data;
        }
    }

    void addToHead(E data){
        Node<E> toAdd =new Node<>(data);
        if(head==null) head=tail=toAdd;
        head.prev=toAdd;
        toAdd.next=head;
        head=toAdd;
    }
    void addToTail(E data){
        Node<E> toAdd =new Node<>(data);
        if(head==null) head=tail=toAdd;
        tail.next=toAdd;
        toAdd.prev=tail;
        tail=toAdd;
    }

    E removeFromHead(){
        if(head==null)return null;
        Node<E>temp=head;
        if(head==tail)head=tail=null;
        else{
            head= head.next;
            head.prev=null;
            temp.next=null;
        }
        return  temp.data;
    }
    E removeFromTail(){
        if(head==null)return null;
        Node<E>temp=tail;
        if(head==tail)head=tail=null;
        else {
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        return temp.data;
    }
    E elementFromHead(){
        return head.data;
    }
    E elementFromTail(){
        return  tail.data;
    }


}
