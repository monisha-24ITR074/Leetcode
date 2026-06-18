class Solution {
    public int countDigitOne(int n) {
        long place=1;
        int count=0;
        while(place<=n){
            long left = n/(place*10);
            long curr = (n/place)%10;
            long right = n%place;

            if(curr==0){
                count += left*place;
            }
            else if(curr==1){
                count += left*place +right+1;
            }else{
                count += (left+1)*place;
            }
            place=place*10;
        }
        return count;
    }
}