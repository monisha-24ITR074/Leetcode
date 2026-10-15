class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int num : nums){
            total+=num;
        }
        if(Math.abs(target)>total){
            return 0;
        }
        if((total+target)%2!=0){
            return 0;
        }
        int sum = (target+total)/2;
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int i : nums){
            for(int j=sum;j>=i;j--){
                dp[j] += dp[j-i];
            }
        }
        return dp[sum];
    }
}