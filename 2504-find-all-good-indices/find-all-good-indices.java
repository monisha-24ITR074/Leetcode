class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] incr = new int[n];
        int[] decr = new int[n];
        incr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                incr[i] = incr[i - 1] + 1;
            } else {
                incr[i] = 1;
            }
        }
        decr[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            if (nums[j] <= nums[j + 1]) {
                decr[j] = decr[j + 1] + 1;
            } else {
                decr[j] = 1;
            }
        }
        ArrayList<Integer> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && i + k <= n - 1) {
                if (incr[i - 1] >= k && decr[i + 1] >= k) {
                    st.add(i);
                }
            }
        }
        return st;
    }
}