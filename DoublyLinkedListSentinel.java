/**
 * 循环双链表
 */
public class DoublyLinkedListSentinel {

    private Node sentinel = new Node(null, -1, null);

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public DoublyLinkedListSentinel(){
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value){

    }

}
