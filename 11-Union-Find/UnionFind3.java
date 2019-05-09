package IMUHERO;
/*第三版的并查集,在第二版的基础上，加入了长度
* 目的：用长度较小的树，指向长度较大的树，可以减小最终形成树的高度，加快查询和连接速度
* */
public class UnionFind3 implements UF{
    int union[];
    int Ulength[];//用于表示每一棵树的大小
    UnionFind3(int size){
        union=new int[size];
        Ulength=new int[size];
        for (int i=0;i<size;i++){
            union[i]=i;//初始的时候，每一个下标指向它自己，表示只和自己联通了
            Ulength[i]=i;
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
        if (Ulength[rootI]<Ulength[rootJ]){
            union[rootI]=rootJ;
            Ulength[rootJ]+=Ulength[rootI];
        }
        else {
            union[rootJ]=rootI;
            Ulength[rootI]+=Ulength[rootJ];
        }

    }
}
