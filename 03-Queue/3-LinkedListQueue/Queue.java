package IMUHERO;

public interface Queue<E> {
     E getFront();
     boolean isEmpty();
     void enqueue(E e);
     E dequeue();
     int getSize();

}
