class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i<0) return -1;
        int j=nums.length-1;
        while(i>=0 && nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i+1,nums.length-1);
        long result = Long.parseLong(new String(nums));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }
    public void swap(char[] nums,int i,int j){
        char temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(char[] nums,int start,int end){
        while(start<end){
            char temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}