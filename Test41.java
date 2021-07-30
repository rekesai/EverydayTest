import java.util.Scanner;
import java.util.Stack;

public class Test41 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1a92fbc771a54feb9eb5bd9b3ff2d0a9?source=relative&toCommentId=9601397
     * 来源：牛客网
     * Emacs号称神的编辑器，它自带了一个计算器。与其他计算器不同，它是基于后缀表达式的，即运算符在操作数的后面。
     * 例如“2 3 +”等价于中缀表达式的“2 + 3”。
     * 请你实现一个后缀表达式的计算器。
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据包括两行：第一行是一个正整数n (3≤n≤50)；紧接着第二行包含n个由数值和运算符组成的列表。
     * “+ - * /”分别为加减乘除四则运算，其中除法为整除，即“5 / 3=1”。
     *
     *输出描述:
     *对应每一组数据，输出它们的运算结果。
     *示例1
     *输入
     *3
     *2 3+
     *5
     *2 2+3*
     *5
     *2 2 3+*
     *输出
     *5
     *12
     *10
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            Stack<String> stack = new Stack<>();
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(!str[i].equals("+") && !str[i].equals("-")
                        && !str[i].equals("*") && !str[i].equals("/")){
                    stack.push(str[i]);
                }
                else{
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    if(str[i].equals("+")){
                        sum = a + b;
                    }
                    if(str[i].equals("-")){
                        sum = b - a;
                    }
                    if(str[i].equals("*")){
                        sum = a * b;
                    }
                    if(str[i].equals("/")){
                        sum = b / a;
                    }
                    stack.push(String.valueOf(sum));
                }
            }
            System.out.println(stack.pop());
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/a811535fed784ea492b63622c28c75c5?toCommentId=9600695
     * NowCoder最近爱上了五子棋，现在给你一个棋局，请你帮忙判断其中有没有五子连珠（超过五颗也算）。
     * 输入描述:
     * 输入有多组数据，每组数据为一张20x20的棋盘。
     * 其中黑子用“*”表示，白子用“+”表示，空白位置用“.”表示。
     * 输出描述:
     * 如果棋盘上存在五子连珠（无论哪种颜色的棋子），输入“Yes”，否则输出“No”。
     * 示例1
     * 输入
     * ....................
     * ....................
     * ....................
     * ....................
     * ......*.............
     * .......*............
     * ........*...........
     * ....++++.*..........
     * ..........*.........
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................

     * ....................
     * ....................
     * ....................
     * .......*............
     * ......+*+++.........
     * .......*............
     * .......*............
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * ....................
     * 输出
     * Yes
     * No
     */
    public static boolean check(char[][] checkerboard){
        // 负责判断4个方向：右、右下、下、左下
        int[][] derection = {{0,1}, {1,1}, {1,0}, {1,-1}};
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(checkerboard[i][j] != '.'){
                    // 开始四个方向的判断
                    for(int k = 0; k < 4; k++){
                        int x = i + derection[k][0];
                        int y = j + derection[k][1];
                        int count = 1;
                        // 当棋子相同数等于5时返回true
                        while(x < 20 && y >= 0 && y < 20
                                && checkerboard[i][j] == checkerboard[x][y]){
                            count++;
                            if(count == 5) return true;
                            x += derection[k][0];
                            y += derection[k][1];
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[][] checkerboard = new char[20][20];
            for(int i = 0; i < 20; i++){
                String tmp = sc.next();
                for(int j = 0; j < 20; j++){
                    checkerboard[i][j] = tmp.charAt(j);
                }
            }
            boolean ret = check(checkerboard);
            if(ret){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
    // 暴力解法
    public static boolean check1(String[] checkerboard, int i, int j){
        if(j < 16 && checkerboard[i].charAt(j) == checkerboard[i].charAt(j+1)
                && checkerboard[i].charAt(j) == checkerboard[i].charAt(j+2)
                && checkerboard[i].charAt(j) == checkerboard[i].charAt(j+3)
                && checkerboard[i].charAt(j) == checkerboard[i].charAt(j+4)){
            return true;
        }
        if(i < 16 && j < 16 && checkerboard[i].charAt(j) == checkerboard[i+1].charAt(j+1)
                && checkerboard[i].charAt(j) == checkerboard[i+2].charAt(j+2)
                && checkerboard[i].charAt(j) == checkerboard[i+3].charAt(j+3)
                && checkerboard[i].charAt(j) == checkerboard[i+4].charAt(j+4)){
            return true;
        }
        if(i < 16 && checkerboard[i].charAt(j) == checkerboard[i+1].charAt(j)
                && checkerboard[i].charAt(j) == checkerboard[i+2].charAt(j)
                && checkerboard[i].charAt(j) == checkerboard[i+3].charAt(j)
                && checkerboard[i].charAt(j) == checkerboard[i+4].charAt(j)){
            return true;
        }
        if(i < 16 && j > 3 && checkerboard[i].charAt(j) == checkerboard[i+1].charAt(j-1)
                && checkerboard[i].charAt(j) == checkerboard[i+2].charAt(j-2)
                && checkerboard[i].charAt(j) == checkerboard[i+3].charAt(j-3)
                && checkerboard[i].charAt(j) == checkerboard[i+4].charAt(j-4)){
            return true;
        }
        return false;
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] checkerboard = new String[20];
            for(int i = 0; i < 20; i++){
                checkerboard[i] = sc.next();
            }
            boolean result = false;
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 20; j++){
                    if(checkerboard[i].charAt(j) != '.'){
                        result = check1(checkerboard, i, j);
                        if(result) break;
                    }
                }
                if(result) break;
            }
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
