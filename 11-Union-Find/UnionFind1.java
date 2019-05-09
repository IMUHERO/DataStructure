package IMUHERO;
/*
* 第一版的并查集，直接用数组内容表示联通的情况，若arr[i]==arr[j]，则表示i和j是联通的
* */
public class UnionFind1 implements UF {
    int [] union;
    public UnionFind1(int size){
        union=new int[size];
        for (int i=0;i<size;i++){
            union[i]=i;
        }
    }

    @Override
    public int getSize() {
        return union.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return union[p]==union[q];
    }

    @Override
    public void UnionElement(int p, int q) {
        int pID=union[p];
        int qId=union[q];
        if (qId==pID)return;
        for (int i=0;i<union.length;i++){
            if (union[i]==pID){
                union[i]=qId;
            }
        }
    }
}
