public class Main {
    public static void main(String[] args) {
        Integer []arr={-2, 0, 3, -5, 2, -1};
        //匿名类
//        SegmentTree<Integer>segTree=new SegmentTree<>(arr,
//                new Merger<Integer>() {
//                    @Override
//                    public Integer merge(Integer left, Integer right) {
//                        return left+right;
//                    }
//                });
        SegmentTree <Integer>segmentTree=new SegmentTree<>(arr,(a,b)->a+b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
