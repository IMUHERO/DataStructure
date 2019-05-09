package IMUHERO;
/*第五版的并查集
 * 在第四版的基础上加上路径压缩，是的树的高度更低了
 * */
public class UnionFind5 implements UF{
    private int union[];
    private int rank[];
    UnionFind5(int size){
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
    //路径压缩在每一次find的时候使用
    public int find(int index){
        while(union[index]!=index){
            union[index]=union[union[index]];//将index的父亲节点定义为父亲的父亲节点
            index=union[index];//每一个数组下标位置的内容都是父亲节点的下标
        }
        return index;
    }

    //路径压缩的第二种方法，递归写法
    public int find2(int index){
        if (union[index]!=index){
            union[index]=find2(union[index]);
        }
        return union[index];
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
