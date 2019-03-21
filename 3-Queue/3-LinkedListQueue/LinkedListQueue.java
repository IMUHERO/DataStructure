package IMUHERO;

/*
* @作者：IMUHERO
* @时间：2019/3/6
* @功能：用链表实现队列
* */

public class LinkedListQueue<E>implements Queue<E> {

    private class Node{
        E e;
        Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head;
    private Node tail;
    private int size ;
    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E getFront() {
        if (isEmpty())throw new IllegalArgumentException("The queue is empty!");
        return head.e;
    }

    @Override
    public void enqueue(E e) {
        if (tail==null){
            tail= new Node(e);//表示Node(e,null),新建一个节点，节点内元素为e,先把这个节点的next指向null，再把这个节点赋值给tail；
            head=tail;
        }
        else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())throw new IllegalArgumentException("The queue is empty,can not dequeue any element!");
        Node retNode=head;
        head =retNode.next;
        retNode.next=null;
        if (head==null)tail=null;
        size--;
        return  retNode.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("queue|front[");
        for(Node cur=head;cur!=null;cur=cur.next)
            stringBuilder.append(cur+"->");
        stringBuilder.append("null]tail");
        return stringBuilder.toString();
    }
}

