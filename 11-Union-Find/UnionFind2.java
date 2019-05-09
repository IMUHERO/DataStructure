package IMUHERO;
/*第二版的并查集,用数组模拟一颗由孩子指向父亲的树，如果两棵树树的根节点arr[i]==arr[j]，则表示这棵树下面的所有节点都是连通的*/
public class UnionFind2 implements UF{
    int union[];
    UnionFind2(int size){
        union=new int[size];
        for (int i=0;i<size;i++){
            union[i]=i;//初始的时候，每一个下标指向它自己，表示只和自己联通了
        }
    }
    @Override
    public int getSize() {
        return union.length;
    }
    //find方法用于查找当前节点对应的根节点
    public int find(int index){
        while(union[index]!=index)index=union[index];//每一个数组下标位置的内容都是父亲节点的下标
        return index;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    //将两个节点连通起来，只要将他们的根节点连通起来即可
    @Override
    public void UnionElement(int i,int j){
        int rootI=find(i);
        int rootJ=find(j);
        if (rootI==rootJ)return;
        union[rootI]=rootJ;

    }
}
