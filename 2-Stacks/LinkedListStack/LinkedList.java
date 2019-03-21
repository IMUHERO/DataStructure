package IMUHERO;
/**
 * @作者：IMUHERO
 * @时间：2019/3/5
 * @内容：带虚拟头结点的链表的基本功能实现
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this.e=e;
            this.next=null;
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead;
    private int size;

    //构造方法，新建虚拟头结点，指向null。size=0;
    public LinkedList(){
        size=0;
        dummyHead=new Node();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    //添加元素
    public void add(int index ,E e){
        Node prev=dummyHead;
        if (index<0||index>size )throw new IllegalArgumentException("index is an illegal input");
        for (int i=0;i<index ;i++){
            prev=prev.next;
        }
        prev.next=new Node(e,prev.next);
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }
    //获得元素
    public E get(int index){
        if (index<0||index>size )throw new IllegalArgumentException("index is an illegal input");
        Node cur =dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        size--;
        return cur.e;
    }
    public E getFirst(){
        return get(0);
    }

    //设置元素
    public void set(int index,E e){
        if (index<0||index>size )throw new IllegalArgumentException("index is an illegal input");
        Node cur =dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
        size++;
    }

    //查询是否含有e元素
    public boolean contain(E e){
        for (Node cur=dummyHead.next;cur!=null;cur=cur.next){
            if (cur.e.equals(e))return true;
        }
        return false;
    }
    //删除索引为index处的元素
    public E remove(int index ){
        if (index<0||index>size )throw new IllegalArgumentException("index is an illegal input");
        Node prev=dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        Node redel=prev.next;
        prev.next=redel.next;
        redel.next=null;
        size--;
        return redel.e;
    }
    public E removeFirst(){
        return remove(0);
    }

    //删除e
    public void removeElement(E e){
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.e.equals(e))break;
                prev=prev.next;
        }
        if (prev.next!=null){
            Node redel=prev.next;
            prev.next=redel.next;
            redel.next=null;
            System.out.println(e+"已经被删除");
        }
        else System.out.println("未查询到元素"+e);

    }

    @Override
    public String toString() {
        StringBuilder strb=new StringBuilder();
            Node cur=dummyHead.next;
            while (cur!=null){
                strb.append(cur.e+"->");
                cur=cur.next;
            }
            strb.append("null");
            return strb.toString();
    }
}
