class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int square=1;
            if(n % (i+1) == 0){
                square=nums[i]*nums[i];
                sum=sum+square;
            }

        }
        return sum;
    }
}