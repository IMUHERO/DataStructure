package IMUHERO;

public class LinkedList_Recurtion<E> {

    //内部类，封装节点
    private class Node{
        E val;
        Node next;
        public Node(E val,Node next){
            this.val=val;
            this.next=next;
        }
        public Node(E val){
            this(val,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    int size;//存储大小
    Node dummyHead;//虚拟头节点

    public LinkedList_Recurtion(){
        size=0;
        dummyHead=new Node();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 使用递归增加节点
     * @param index
     * @param val
     */
    public void add(int index,E val){
        add(index,val,dummyHead);
        size++;
    }

    public void add(int index,E val,Node cur){
        if (cur==null) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        if (index==0) {
            cur.next=new Node(val,cur.next);
            return;
        }
        add(index-1,val,cur.next);
        return;
    }

    public void addFirst(E val){
        add(0,val);
    }

    public void addLast(E val){
        add(size,val);
    }

    /**
     * 使用递归删除节点
     * @param index
     * @return 待删除元素 E val
     */
    public E remove(int index){
        E val= remove(index,dummyHead);
        size--;
        return val;
    }

    public E remove(int index,Node cur){
        if (cur.next==null) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        if (index==0) {
            E res=cur.next.val;
            cur.next=cur.next.next;
            return res;
        }
        return remove(index-1,cur.next);
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 功能与增删类似，不再累述
     * @return 修改前的E val
     */
    // public E set(int index,E val){

    // }

    /**
     * 功能与增删类似，不再累述
     * @return E val
     */
    // public E get(int index){

    // }


    /**
     * 使用递归重写toString();
     * @return String
     */
    @Override
    public String toString() {
        StringBuffer stb=new StringBuffer();
        stb.append("[");
        toString(dummyHead,stb);
        stb.append("null]");
        return stb.toString();
    }
    private String toString(Node cur,StringBuffer stb){
        if (cur.next==null)return stb.toString();
        stb.append(cur.next.val+"->");
        return toString(cur.next,stb);
    }

}
