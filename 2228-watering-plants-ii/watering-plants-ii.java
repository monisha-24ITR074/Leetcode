class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int waterA=capacityA;
        int waterB=capacityB;
        int count=0;
        int left=0;
        int right=plants.length-1;
        while(left<right){
            if(plants[left]>waterA){
                count++;
                waterA=capacityA;
            }
            waterA=waterA-plants[left];
            left++;

            if(plants[right]>waterB){
                count++;
                waterB=capacityB;
            }
            waterB=waterB-plants[right];
            right--;
        }
        if(left==right){
            if(waterA>=waterB){
                if(waterA<plants[left]){
                    count++;
                }
            }
            else{
                if(waterB<plants[right]){
                    count++;
                }
            }
        }
        return count;
    }
}