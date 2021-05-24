package practice.dequeue;

public class MainClass {
    public static void main(String[] args) {
        MyArrayDeq<Integer> myArrayDeq= new MyArrayDeq<>();
        myArrayDeq.addToHead(43);
        myArrayDeq.addToTail(56);
        myArrayDeq.addToHead(12);
        myArrayDeq.addToTail(78);
        System.out.println(myArrayDeq.elementFromHead());
        System.out.println(myArrayDeq.elementFromTail());
        System.out.println(myArrayDeq.removeFromHead());
        System.out.println(myArrayDeq.elementFromHead());
    }
}
