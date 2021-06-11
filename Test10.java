import java.util.Scanner;





public class Test10 {



    public final static native int w();


    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        //b3 =  (b1 + b2);   编译出错
    }
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int count = 0;
        if(str.length() <= 4){
            count += 5;
        }
        else if(str.length() <= 7){
            count += 10;
        }
        else{
            count += 25;
        }
        int flagNum = 0;
        int flagE = 0;
        int flage = 0;
        int flagSymbol = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57){
                flagNum++;
            }
            if(ch >= 65 && ch <= 90){
                flagE++;
            }
            if(ch >= 97 && ch <= 122){
                flage++;
            }
            if(ch >= 0x21 && ch <= 0x2F || ch >= 0x3A && ch <= 0x40
                    || ch >= 0x5B && ch <= 0x60 || ch >= 0x7B && ch <= 0x7E){
                flagSymbol++;
            }
        }
        if(flagNum == 1){
            count += 10;
        }
        else if(flagNum > 1){
            count += 20;
        }
        if(flagE == 0 && flage != 0 || flagE != 0 && flage == 0){
            count +=10;
        }
        else if(flagE != 0 && flage != 0){
            count += 20;
        }
        if(flagSymbol == 1){
            count += 10;
        }
        else if(flagSymbol > 1){
            count += 25;
        }
        if(count >= 90){
            System.out.println("VERY_SECURE");
        }
        else if(count >= 80){
            System.out.println("SECURE");
        }
        else if(count >= 70){
            System.out.println("VERY_STRONG");
        }
        else if(count >= 60){
            System.out.println("SECURE");
        }
        else if(count >= 50){
            System.out.println("AVERAGE");
        }
        else if(count >= 25){
            System.out.println("WEAK");
        }
        else{
            System.out.println("VERY_WEAK");
        }
    }


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
