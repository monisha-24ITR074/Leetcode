class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;int count=0;
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        int avg=0;
        avg=sum/k;
        if(avg>=threshold){
            count++;
        }
        int max=sum;
        for(int i=k;i<arr.length;i++){
            sum=sum+arr[i];
            sum=sum-arr[i-k];
            avg=sum/k;
            if(avg>=threshold){
                count++;
            }
        }
        return count;
    }
}