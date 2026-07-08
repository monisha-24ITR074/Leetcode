class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum=0;
        long[] prefixSum = new long[n];
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            prefixSum[i]=sum;
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            if(prefixSum[i]>=prefixSum[n-1]-prefixSum[i]){
                count++;
            }
        }
        return count;
    }
}