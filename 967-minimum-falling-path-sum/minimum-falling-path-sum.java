class Solution {
    public int minFallingPathSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp  =new int[rows][cols];
        //filling 1st rows
        for(int j=0;j<cols;j++){
            dp[0][j]=mat[0][j];
        }
        for(int i=1;i<rows;i++){
            //handle 0th column here
            dp[i][0]=mat[i][0] + Math.min(dp[i-1][0],dp[i-1][1]);
            for(int j=1;j<cols-1;j++){
                int up = dp[i-1][j];
                int dia_left = dp[i-1][j-1];
                int dia_right = dp[i-1][j+1];
                dp[i][j] = mat[i][j]+Math.min(up,Math.min(dia_left,dia_right));
            }
            //handle min column here
            int j=cols-1;
            dp[i][cols-1]=mat[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
        }
        int res = Integer.MAX_VALUE;
        for(int j=0;j<cols;j++){
            res = Math.min(res,dp[rows-1][j]);
        }
        return res;
    }
}