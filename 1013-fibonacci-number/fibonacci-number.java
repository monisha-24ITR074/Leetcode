class Solution {
    public int fib(int n) { 
    //     // memorization  - top down
    //     int[] dp = new int[n+1] ;
    //     Arrays.fill(dp,-1);
    //     int ans = solve(n,dp);
    //     return ans;
    // }
    // public int solve(int n,int[] dp){ // dp means dynamic programming

    //     if(n <= 1) {
    //         return n;
    //     }
    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
    //     dp[n]=solve(n-1,dp)+solve(n-2,dp);
    //     return dp[n];

        int[] dp = new int[n+1];  //Tabulation method - bottom-up
        if(n<=1) return n;
        dp[0]=0 ;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}