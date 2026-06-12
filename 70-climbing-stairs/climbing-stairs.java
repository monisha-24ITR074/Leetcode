class Solution {
    public int climbStairs(int n) {
        
        if(n==0) return 1;
        if(n<0) return 0;
        int prev2=1;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int temp=prev2+prev1;
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}