class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int tsum=0;
        for(int i=0;i<n;i++){
            tsum+=nums[i];
        }
        int lsum=0;
        for(int i=0;i<n;i++){
            int rsum = tsum-lsum-nums[i];
            res[i]=Math.abs(lsum-rsum);
            lsum+=nums[i];
        }
        return res;
    }
}
        // prefix[0]=nums[0];
        // for(int i=1;i<nums.length;i++){ 
        //     nums[i]=nums[i]+nums[i-1];
        // }
        // suffix[n-1]=nums[n-1];
        // for(int j=num.length-2;j>=0;i--){
        //     nums[j]=nums[j]+nums[j+1];
        // }