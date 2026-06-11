class Solution {
    static class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;  //row
        int cols = grid[0].length; //col
        Queue<Pair> q = new LinkedList<>(); //queue //pair-type
        int fresh = 0;  // beacuse we have to count the fresh oranges
        
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.add(new Pair(r,c));
                }
                else if(grid[r][c]==1){
                    fresh++;
                }
            }
        } 
        if (fresh == 0) {
            return 0;
        }
        int minutes=-1;   // actual meanig of this is level
        while(!q.isEmpty()){
            int size = q.size();  // i will try to see my size
            for(int i=0;i<size;i++){  // how much size we have?? that much you remove
                Pair curr = q.remove(); // lets remove it and it is a pair
                int row =  curr.row;
                int col =  curr.col;

                //up
                // for up row-1,col
                if(row-1 >= 0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;  //rotten
                    fresh--;  // reduce the fresh oranges
                    q.add(new Pair(row - 1,col)); // you will add
                }
                if(row+1<rows && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    fresh--;
                    q.add(new Pair(row+1,col));
                }
                if(col-1 >= 0 && grid[row][col-1]==1) {
                    grid[row][col-1]=2;
                    fresh--;
                    q.add(new Pair(row,col-1));
                }
                if(col+1<cols && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    fresh--;
                    q.add(new Pair(row,col+1));
                }
            }
            minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}