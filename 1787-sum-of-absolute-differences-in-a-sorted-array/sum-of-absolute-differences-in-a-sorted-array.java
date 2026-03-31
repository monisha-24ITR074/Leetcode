class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            if (i > 0)
                left = nums[i] * i - prefix[i - 1];
            if (i < n - 1)
                right = suffix[i + 1] - nums[i] * (n - i - 1);
            res[i] = left + right;
        }
        return res;
    }
}