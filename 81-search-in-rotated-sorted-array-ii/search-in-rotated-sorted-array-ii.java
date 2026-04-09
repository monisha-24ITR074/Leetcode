class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return true;
            if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            }
            else if(nums[left]<=nums[mid]){
                if(target>=nums[left]){
                    if(nums[mid]>target){
                        right=right-1;
                    }
                    else {
                        left=left+1;
                    }
                }
                else{
                    left=mid+1;
                }
            }else{
                if(target<=nums[right]){
                    if(nums[mid]<target){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }else{
                    right=mid-1;
                }
            }
        }
    return false;
    }
}