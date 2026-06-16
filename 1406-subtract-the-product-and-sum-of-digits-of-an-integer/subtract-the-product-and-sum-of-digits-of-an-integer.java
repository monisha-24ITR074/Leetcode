class Solution {
    public int subtractProductAndSum(int n) {
        int mul=1;
        int sum=0;
        int d;
        while(n!=0){
            d = n%10;
            n = n/10;
            sum=sum+d;
            mul=mul*d;
        }
        return mul-sum;
    }
}