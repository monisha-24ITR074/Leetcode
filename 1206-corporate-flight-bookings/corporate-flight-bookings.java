class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res =new int[n];
        for(int i=0;i<bookings.length;i++){
            int first=bookings[i][0]-1;
            int last=bookings[i][1]-1;
            int seat=bookings[i][2];
            res[first]+=seat;
            if(last+1 < n){
                res[last+1]-=seat;
            }
        }
        for(int i=1;i<n;i++){
            res[i]=res[i]+res[i-1];
        }
        return res;
    }
}