class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            while(sum>=target){
                ans = Math.min(ans,right-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE ? 0: ans;
    }
}
// int sum=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 sum=sum+nums[i];
//             }
//             if(sum>=target){
//                 minimum=Math.min(minimum,j-i+1);
//             }
//         }
//         return minimum;