package IMUHERO;

public class MaxHeap <E extends Comparable<E>>{
   public Array<E> data;
   public MaxHeap(int capacity){
        data=new Array<>(capacity);
   }
   public MaxHeap(){
       data=new Array<>();
   }

   //heapify,将一个数组转换成最大堆
   public MaxHeap(E [] arr){
        data=new Array<>(arr);
        for (int i=parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
   }
   public boolean isEmpty(){
       return data.isEmpty();
   }

   public int getSize(){
       return data.getSize();
   }

   private int parent (int index){
       return (index-1)/2;
   }
   private int leftChild(int index){
       return index*2+1;
   }
   private int rightChild(int index){
       return index*2+2;
   }

   public void add(E e){
       data.addLast(e);
       siftUp(data.getSize()-1);
   }
   private void siftUp(int index){
       while(index>0&&data.get(parent(index)).compareTo(data.get(index))<0){
           data.swap(parent(index),index);
           index=parent(index);
       }
   }

   public E findMax(){
       if (getSize()==0)throw new IllegalArgumentException("There is no element exist");
       return data.get(0);
   }

   public E extractMax(){
       E reMax=findMax();
       data.swap(0,getSize()-1);
       data.removeLast();
       siftDown(0);
       return reMax;
   }

   private void siftDown(int index){
       if (index<0||index>getSize())throw new IllegalArgumentException("Index is illegal");
       while(leftChild(index)<getSize()){
           int j=leftChild(index);
           if (j++<getSize()&&data.get(j).compareTo(data.get(j+1))<0)
               j++;
           if (data.get(j).compareTo(data.get(index))<=0) {
               break;       //父亲节点大于等于子节点中最大的值则直接跳出循环
           }
           data.swap(j,index);//如果子节点中有比父亲节点大，则交换并进行下一轮判断
           index=j;
       }
   }

   public E replace(E e){
        E reMax=findMax();
        data.set(0,e);
        siftDown(0);
        return reMax;
   }
}
