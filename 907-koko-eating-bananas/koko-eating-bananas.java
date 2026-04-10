class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = getMax(piles);
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canFinish(piles,h,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] piles,int h,int k){
        int hours=0;
        for(int pile : piles){
            hours += pile/k;
            if(pile % k != 0){
                hours++;
            }
            if(hours>h) return false;
        }
        return true;
    }
    private int getMax(int[] piles){
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }
}