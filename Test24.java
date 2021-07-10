import java.util.HashSet;
import java.util.Scanner;

public class Test24 {
    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        while(jin.hasNext()) {
            int row = jin.nextInt();
            int col = jin.nextInt();
            int[][] maze = new int[row][col];
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    maze[i][j] = jin.nextInt();
            check(maze, 0, 0);//预先探测迷宫一遍，将走不通的路置1
            System.out.println(mazePath(maze, 0, 0));//正式走迷宫
        }
    }
    public static int check(int[][] maze, int x, int y) {
        //如果是右下角的出口
        if(x == maze.length - 1 && y == maze[x].length - 1) return 1;
        //如果当前位置是路
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            //如果下一步横竖都是死
            if(check(maze, x + 1, y) == -1 && check(maze, x, y + 1) == -1) {
                //将本位置封死
                maze[x][y] = 1;
                return -1;
            }
            else {
                return 1;
            }
        }
        //如果当前位置不是路
        else {
            return -1;
        }
    }
    public static String mazePath(int[][] maze, int x, int y) {
        //如果是右下角的出口，返回坐标
        if(x == maze.length - 1 && y == maze[x].length - 1) {
            return "(" + x + "," + y + ")";
        }
        //如果当前位置是路，返回坐标并且继续前进
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            return "(" + x + "," + y + ")" + "\n" + mazePath(maze, x + 1, y) + mazePath(maze, x, y + 1);
        }
        //如果当前位置不是路，什么也不做
        else {
            return "";
        }
    }




    /**
     * 链接：https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab?commentTags=Java
     * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
     * 游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
     * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，
     * 一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
     * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
     * 思路：
     * 除了第一行或者第一列外，矩阵其余每个点的上一步走法都来自该点上方或者左方，该点选择上方或左方两个点中累加和最大的点进行累加，获得该点的最大价值
     * 矩阵右下角那个点的值就是最佳走法获得的最大价值。
     */

    public int getMost(int[][] board) {
        // 初始化第一行和第一列的原因是他们的价值只来自于左边或者上面的其中一个
        for(int i = 1; i < 6; i++){
            board[0][i] += board[0][i-1];//先初始化第一行
            board[i][0] += board[i-1][0];//先初始化第一列
        }
        // 第二行第二列开始，从上到下从左到右进行最大累加，从第二行第二列开始才有的选择是上方最大还是左边最大
        // 逐渐累加，一直到右下角
        for(int i = 1; i < 6; i++){
            for(int j = 1; j < 6; j++){
                //board[i][j] += board[i-1][j] > board[i][j-1] ? board[i-1][j] : board[i][j-1];
                board[i][j] += Math.max(board[i - 1][j], board[i][j - 1]);
            }
        }
        // 右下角，即最佳走法获得的最大价值
        return board[5][5];
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     * 链接：https://leetcode-cn.com/problems/contains-duplicate
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main1(String[] args){
        int[] nums = {1,11};
        System.out.println(containsDuplicate(nums));
    }
}
