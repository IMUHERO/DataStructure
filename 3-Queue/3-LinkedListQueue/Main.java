package IMUHERO;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListQueue queue=new LinkedListQueue();
        System.out.println(queue);
        for (int i=0;i<5;i++){
            queue.enqueue(i);
            System.out.println(queue);
        }

        for (int i=0;i<3;i++){
            queue.dequeue();
            System.out.println(queue);
        }

        System.out.println("队列的大小为："+queue.getSize());
        System.out.println("队首第一个元素为："+queue.getFront());

    }
}
