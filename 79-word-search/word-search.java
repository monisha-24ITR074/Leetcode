class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int i,int j,int index,char[][] board,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ||  board[i][j] != word.charAt(index)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='#';
        boolean found = 
            backtrack(i+1,j,index+1,board,word) ||
            backtrack(i-1,j,index+1,board,word) ||
            backtrack(i,j+1,index+1,board,word) ||
            backtrack(i,j-1,index+1,board,word);
        board[i][j]=temp;
        return found;
    }
}