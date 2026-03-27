class Solution {
    public int countDigits(int num) {
        int count=0;
        int temp=num;
        while(temp!=0){
            int r= temp%10;
            if(r!=0 && num%r==0){
                count++;
            }
            temp=temp/10;
        }
        return count;
    }
}