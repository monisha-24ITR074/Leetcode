class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=getMax(weights);
        int right=getSum(weights);
        int ans=right;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(packages(weights,days,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    private boolean packages(int[] weights,int totaldays,int capacity){
        int currentload = 0 ;
        int daysNeeded = 1;
        for(int weight : weights){
            if(currentload + weight > capacity){
                daysNeeded++;
                currentload =  weight;
            }
            else{
                currentload += weight;
            }
        }
        return daysNeeded <= totaldays;
    }
    private int getMax(int[] weights){
        int max = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
        }
        return max;
    }
    private int getSum(int[] piles){
        int sum = 0;
        for(int pile : piles){
            sum += pile;
        }
    return sum;
    }
}