class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long total = 0;
        for(int i=0;i<n;i++){
            total=total+beans[i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long kept = (long) beans[i] * (n - i);
            long removed = total - kept;
            min = Math.min(min, removed);
        }
        return min;
    }
}