import java.util.Scanner;
public class Test40 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d83721575bd4418eae76c916483493de
     * 广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。
     * 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，
     * 其中最长的长度为4。
     * 输入描述:
     * 输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000）。
     * 紧接着第二行包含n个正整数m（1≤n≤10000），代表队伍中每位队员的身高。
     *
     * 输出描述:
     * 对应每一组数据，输出最长递增子序列的长度。
     * 示例1
     * 输入
     * 7
     * 1 7 3 5 9 4 8
     * 6
     * 1 3 5 2 4 6
     * 输出
     * 4
     * 4
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int result = 1;//结果
            int[] array = new int[n];//数据初始化
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (array[j] < array[i] && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        result = Math.max(dp[i], result);
                    }
                }
            }
            System.out.println(result);
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/95e35e7f6ad34821bc2958e37c08918b
     * NowCoder每天要给很多人发邮件。有一天他发现发错了邮件，把发给A的邮件发给了B，把发给B的邮件发给了A。
     * 于是他就思考，要给n个人发邮件，在每个人仅收到1封邮件的情况下，有多少种情况是所有人都收到了错误的邮件？
     * 即没有人收到属于自己的邮件。
     * 输入描述:
     * 输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
     * 输出描述:
     * 对应每一组数据，输出一个正整数，表示无人收到自己邮件的种数。
     * 示例1
     * 输入
     * 2<br/>3
     * 输出
     * 1<br/>2
     *
     * 链接：https://www.nowcoder.com/questionTerminal/95e35e7f6ad34821bc2958e37c08918b
     * 来源：牛客网
     * 错排问题。
     * 当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用D(n)表示，
     * 那么D(n-1)就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
     * 第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
     * 第二步，放编号为k的元素，这时有两种情况：
     * ⑴把它放到位置n，那么，对于剩下的n-1个元素，由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法；
     * ⑵第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法；
     * 综上得到
     * D(n) = (n-1) [D(n-2) + D(n-1)]
     * 特殊地，D(1) = 0, D(2) = 1.
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        long[] array = new long[20];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < 20; i++){
            array[i] = (long)(i*(array[i-1]+array[i-2]));
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(array[n-1]);
        }
    }
}