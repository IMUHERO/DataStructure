//leetcode303，利用数组求解
class NumArray2 {
    //数组data用于存放第i个元素之前所有数值的和
    int[]data;
    public NumArray2(int[] nums) {
        data=new int[nums.length+1];
        data[0]=0;
        for (int i=1;i<nums.length+1;i++){
            data[i]=data[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return data[i+1]-data[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */