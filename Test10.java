public class Test10 {

    //求高效算法得出玩井字棋的玩家是否获胜
    public boolean checkWon(int[][] board) {
        // write code here
        //行相同
        for(int i = 0; i < 3; i++){
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!=0){
                if(board[i][0]==1){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        //列相同
        for(int i = 0; i < 3; i++){
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[0][i]!=0){
                if(board[0][i]==1){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[1][1]!=0){
            if(board[1][1] == 1){
                return true;
            }
            else{
                return false;
            }
        }
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[1][1]!=0){
            if(board[1][1] == 1){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
