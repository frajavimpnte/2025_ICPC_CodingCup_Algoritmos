// javac Exercise05BasicCustomContainer.java
// java Exercise05BasicCustomContainer

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class Exercise05BasicCustomContainer {
    private SinglyLinkedListNode head = null;

    public Exercise05BasicCustomContainer() {
    }

    public Exercise05BasicCustomContainer(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            this.pushFront(datos[i]);
        }
    }
    public void pushFront(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val, null);
        if ( head != null)
            newNode.next = head;
        head = newNode;
    }

    public int popFront() {
        var first = head;
        int dato = first.data;
        if (head != null) {
            head = head.next;
            first = null;
        }
        return dato;
    }

    public static void main(String []args) {
        int[] arr = {1,2,3};
        Exercise05BasicCustomContainer sll = new Exercise05BasicCustomContainer(arr);
        
        System.out.println("sll.popFront(): " + sll.popFront());
        System.out.println("sll.popFront(): " + sll.popFront());
        System.out.println("sll.popFront(): " + sll.popFront());
        System.out.println("sll.popFront(): " + sll.popFront());
    }
}