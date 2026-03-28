class Solution {
    public int maxArea(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int max = 0;
        while(left < right) {
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            max = Math.max(max, area);
            if(arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}