// javac Exercise05BasicCustomContainerGeneric.java
// java Exercise05BasicCustomContainerGeneric

import java.util.Iterator;
import java.util.NoSuchElementException;

class SinglyLinkedListNodeGeneric<T> {
    public T data;
    public SinglyLinkedListNodeGeneric<T> next;

    public SinglyLinkedListNodeGeneric(T data, SinglyLinkedListNodeGeneric<T> next) {
        this.data = data;
        this.next = next;
    }
}

public class Exercise05BasicCustomContainerGeneric<T> implements Iterable<T> {
    private SinglyLinkedListNodeGeneric<T> head = null;
    private int size = 0;

    public Exercise05BasicCustomContainerGeneric() {
    }

    public Exercise05BasicCustomContainerGeneric(T[] datos) {
        for (int i = 0; i < datos.length; i++) {
            this.pushFront(datos[i]);
        }
        size = datos.length;
    }

    public void pushFront(T val) {
        SinglyLinkedListNodeGeneric<T> newNode = new SinglyLinkedListNodeGeneric<>(val, null);
        if ( head != null)
            newNode.next = head;
        head = newNode;
        size++;
    }

    public T popFront() {
        var first = head;
        T dato = (T) first.data;
        if (head != null) {
            head = head.next;
            first = null;
        }
        size--;
        return dato;
    }

    // Iterator
    private class BCCGenericIterator implements Iterator<T> {
        private int j = 0;
        private SinglyLinkedListNodeGeneric<T> current = head;
        private boolean removable = false;

        @Override
        public boolean hasNext( ) { return j < size; }

        @Override
        public T next( ) throws NoSuchElementException {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;       // this element can subsequently be removed

            T dato = current.data;
            current = current.next;
            j++;
            return  dato;   // post-increment j, so it is ready for future call to next
        }

        @Override
        public void remove( ) throws IllegalStateException {
            if (!removable) throw new IllegalStateException("nothing to remove");
            // !!! not implemented
            //ArrayList.this.remove(j-1); // that was the last one returned

            //j--; // next element has shifted one cell to the left
            //removable = false; // do not allow remove again until next is called
        }
    }

    public Iterator<T> iterator( ) { 
        return new BCCGenericIterator( ); // create a new instance of the inner class
    }

    public static void main(String []args) {
        System.out.println("Integer single linked list popFront()-------------");
        Integer[] arr = {1,2,3};
        Exercise05BasicCustomContainerGeneric<Integer> sllInteger = new Exercise05BasicCustomContainerGeneric<>(arr);

        System.out.println("sll.popFront(): " + sllInteger.popFront());
        System.out.println("sll.popFront(): " + sllInteger.popFront());
        System.out.println("sll.popFront(): " + sllInteger.popFront());
        // System.out.println("sll.popFront(): " + sll.popFront()); // Exception
        
        System.out.println("Iterator single linked list-----------------------");
        String[] arrString = {"juan","pedro","maria"};
        Exercise05BasicCustomContainerGeneric<String> sllString = new Exercise05BasicCustomContainerGeneric<>(arrString);

        Iterator<String> walk = sllString.iterator();
        while (walk.hasNext( ))
            System.out.println( walk.next( ) );

        System.out.println("Iterable single linked list-----------------------");
        for (String dato : sllString) {
            System.out.println(dato);
         }
   
    }
}