import java.util.Scanner;

public class Test29 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/296c2c18037843a7b719cf4c9c0144e4
     * 给定一个全是正数的数组arr，定义一下arr的最小不可组成和的概念：
     * 1，arr的所有非空子集中，把每个子集内的所有元素加起来会出现很多的值，其中最小的记为min，最大的记为max；
     * 2，在区间[min,max]上，如果有一些正数不可以被arr某一个子集相加得到，那么这些正数中最小的那个，就是arr的最小不可组成和；
     * 3，在区间[min,max]上，如果所有的数都可以被arr的某一个子集相加得到，那么max+1是arr的最小不可组成和；
     * 举例： arr = {3,2,5} arr的min为2，max为10，
     *      在区间[2,10]上，4是不能被任何一个子集相加得到的值中最小的，
     *      所以4是arr的最小不可组成和；
     *      arr = {3,2,4} arr的min为2，max为9，
     *      在区间[2,9]上，8是不能被任何一个子集相加得到的值中最小的，
     *      所以8是arr的最小不可组成和；
     *      arr = {3,1,2} arr的min为1，max为6，
     *      在区间[2,6]上，任何数都可以被某一个子集相加得到，
     *      所以7是arr的最小不可组成和；
     *      请写函数返回arr的最小不可组成和。
     */
    public int getFirstUnFormedNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0;i < arr.length;i++) {
            min = Math.min(min, arr[i]);
            max += arr[i];
        }
        boolean[] dp = new boolean[max + 1];
        dp[0] = true;
        dp[arr[0]] = true;
        for (int i = 1;i < arr.length; i++) {
            for (int col = dp.length - 1; col-arr[i] >= 0; col--) {
                dp[col] = dp[col - arr[i]] ? true : dp[col];
            }
        }
        for (int num = min + 1; num <= max; num++) {
            if(! dp[num]) {
                return num;
            }
        }
        return max + 1;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1d18c0841e64454cbc3afaea05e2f63c
     *
     * 居然有假币！ 现在猪肉涨了，但是农民的工资却不见涨啊，没钱怎么买猪肉啊。
     * nowcoder这就去买猪肉，结果找来的零钱中有假币！！！
     * 可惜nowcoder 一不小心把它混进了一堆真币里面去了。
     * 只知道假币的重量比真币的质量要轻，给你一个天平（天平两端能容纳无限个硬币）
     * 请用最快的时间把那个可恶的假币找出来。
     *
     * 输入描述:
     * 1≤n≤2^30,输入0结束程序。
     *
     * 输出描述:
     * 最多要称几次一定能把那个假币找出来？
     * 示例1
     * 输入
     * 3
     * 12
     * 0
     * 输出
     * 1
     * 3
     */
    public static int findFakeCoin(int n){
        if(n == 1) return 0;
        if(n < 4) return 1;
        return 1+findFakeCoin((n+2)/3);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            if(n == 0) break;
            System.out.println(findFakeCoin(n));
        }
    }
}
