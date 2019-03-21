package IMUHERO;


import java.security.KeyRep;

public class LinkedListMap<K,V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key , V value,Node next){
            this.key = key;
            this.value=value;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null, null);
        }

        @Override
        public String toString(){
            return key.toString()+":"+value;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表map中的元素个数
    @Override
    public int getSize(){
        return size;
    }

    // 返回链表map是否为空
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    //私有方法，用来获取key所在的节点
    private Node getNode(K key){
        Node cur=dummyHead.next;
        while(cur!=null){
            if (cur.key.equals(key)) {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //判断是否包含key

    @Override
    public boolean contains(K key) {
        Node reNode=getNode(key);
        return reNode!=null;

    }
    //获得该键对应的值
    @Override
    public V get(K key){
        Node reNode=getNode(key);
        if (reNode==null)throw new IllegalArgumentException("key="+key+" is not exist");
        else return reNode.value;
    }

    // 在链表map的K位置添加新的元素e
    public void add(K key, V value){
        Node reNode=getNode(key);
        if (reNode==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }
        else reNode.value=value;
    }

    //修改对应键对应位置的值为newValue
    @Override
    public void set(K key, V newValue){
        Node reNode=getNode(key);
        if (reNode==null)throw new IllegalArgumentException("There has not a key exist in:"+key);
        else
            reNode.value=newValue;

    }

    @Override
    public V remove(K key){
        Node prev=dummyHead.next;
        while(prev.next!=null){
            if (prev.next.key.equals(key)) {
                Node reNode =prev.next;
                prev.next=reNode.next;
                reNode.next=null;
                size--;
                return reNode.value;
            }
            prev=prev.next;
        }
        return null;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
