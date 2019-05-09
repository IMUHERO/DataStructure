 //leetcode303，利用线段树快速求解
class NumArray {
     interface Merger<E> {
        public E merge(E a,E b);
    }
    public class SegmentTree<E> {
        private E data[];
        private E tree[];
        private Merger<E>merger;
        public SegmentTree(E []arr,Merger<E>merger){
            data=(E[])new Object[arr.length];
            tree=(E[])new Object[4*arr.length];
            this.merger=merger;
            for (int i=0;i<arr.length;i++){
                data[i]=arr[i];
            }
            buildSegmentTree(0,0,arr.length-1);
        }

        public E get(int index){
            if (index<0||index>=data.length)throw new IllegalArgumentException("Index is illegal!");
            return data[index];
        }

        public int getSize(){
            return data.length;
        }

        public int leftChild(int index){
            if (index<0||index>=tree.length)throw new IllegalArgumentException("Index is illegal!");
            return index*2+1;
        }
        public int rightChild(int index){
            if (index<0||index>=tree.length)throw new IllegalArgumentException("Index is illegal!");
            return index*2+2;
        }
        //用于创建线段树
        public void buildSegmentTree(int treeIndex,int l,int r){
            if (l==r){
                tree[treeIndex]=data[l];
                return;
            }
            int mid=l+(r-l)/2;
            int treeLeftChild=leftChild(treeIndex);
            int treeRightChild=rightChild(treeIndex);
            buildSegmentTree(treeLeftChild,l,mid);
            buildSegmentTree(treeRightChild,mid+1,r);
            tree[treeIndex]=merger.merge(tree[treeLeftChild],tree[treeRightChild]);
        }

        //用于查询[queryL,queryR]之间的和
        public E query(int queryL,int queryR){
            if (queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR)
                throw new IllegalArgumentException("Index is illegal!");
            return query(0,0,data.length-1,queryL,queryR);
        }

        private E query(int treeIndex,int l,int r,int queryL,int queryR){
            int mid =l+(r-l)/2;
            int treeLeftChild=leftChild(treeIndex);
            int treeRightChild=rightChild(treeIndex);
            if (l==queryL&&r==queryR){
                return tree[treeIndex];
            }
            if (queryL>mid){
                return query(treeRightChild,mid+1,r,queryL,queryR);
            }
            else if (queryR<=mid){
                return query(treeLeftChild,l,mid,queryL,queryR);
            }
            E leftResult = query(treeLeftChild, l, mid, queryL, mid);
            E rightResult = query(treeRightChild, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append('[');
            for(int i = 0 ; i < tree.length ; i ++){
                if(tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");

                if(i != tree.length - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }
    }
    private SegmentTree<Integer>segmentTree;
    public NumArray(int[] nums) {
        if (nums.length>0){
            Integer[]data=new Integer[nums.length];
            for (int i=0;i<nums.length;i++){
                data[i]=nums[i];
            }
            segmentTree=new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */