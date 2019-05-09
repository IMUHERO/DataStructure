package IMUHERO;
/*第四版的并查集
* 由于第三版的并查集是以长度作为考量，较小的树指向较大的树，这样在逻辑上是经不起推敲的
* 因为实际上较小的树不一定代表高度低，他也可能是宽度大，因此以高度作为衡量标准，显然更合理
* */
public class UnionFind4 implements UF{
    int union[];
    int rank[];
    UnionFind4(int size){
        union=new int[size];
        rank =new int[size];
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
        if (rank[rootI]< rank[rootJ]){
            union[rootI]=rootJ;
        }
        else if (rank[rootJ]<rank[rootI]){
            union[rootJ]=rootI;

        }
        //只有在相等的时候，rank才需要+1
        else {
            union[rootJ]=rootI;
            rank [rootI]+=1;
        }
    }
}
