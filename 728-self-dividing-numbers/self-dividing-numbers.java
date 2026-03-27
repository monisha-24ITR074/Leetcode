class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            int temp=i;
            boolean isvalid=true;
            while(temp!=0){
                int r=temp%10;
                if(r==0 || i%r!=0){
                    isvalid=false;
                }
                temp=temp/10;
            }
            if(isvalid){
                result.add(i);
            }
        }
        return result;
    }
}