package IMUHERO;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    MaxHeap<E> priorityQueue=new MaxHeap<>();

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int getSize() {
        return priorityQueue.getSize();
    }

    @Override
    public void enqueue(E e) {
        priorityQueue.add(e);
    }

    @Override
    public E dequeue() {
        return priorityQueue.extractMax();
    }

    @Override
    public E getFront() {
        return priorityQueue.findMax();
    }
}
