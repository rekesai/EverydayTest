import java.util.Scanner;

public class Test26 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/82424d93369649b98720743c25edc6ce
     *
     * 小喵们很喜欢把自己装进容器里的（例如碗），但是要是碗的周长比喵的身长还短，它们就进不去了。
     * 现在告诉你它们的身长，和碗的半径，请判断一下能否到碗里去。
     *
     * 输入描述:
     * 输入有多组数据。
     * 每组数据包含两个整数n (1≤n≤2^128) 和r (1≤r≤2^128)，分别代表喵的身长和碗的半径。
     * 圆周率使用3.14。
     *
     * 输出描述:
     * 对应每一组数据，如果喵能装进碗里就输出“Yes”；否则输出“No”。
     * 示例1
     * 输入
     * 6 1
     * 7 1
     * 9876543210 1234567890
     * 输出
     * Yes
     * No
     * No
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            double n = s.nextDouble();
            double r = s.nextDouble();
            if(n < 2*3.14*r){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }



    /**
     * https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
     * 示例1
     * 输入
     * 3
     * 输出
     * 4
     * 题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解题解
     * 链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
     * 来源：牛客网
     *
     * 关于本题，前提是n个台阶会有一次n阶的跳法。分析如下:
     * f(1) = 1
     *
     * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
     *
     * f(3) = f(3-1) + f(3-2) + f(3-3)
     *
     * ...
     *
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     *
     * 说明：
     * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
     *
     * 2）n = 1时，只有1种跳法，f(1) = 1
     *
     * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     *
     * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     *
     *     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     *
     *     因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     *
     * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     *
     *     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     *
     * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
     *
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     *     可以得出：
     *     f(n) = 2*f(n-1)
     *
     * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *           | 1       ,  (n=0 )
     * f(n) =    | 1       ,  (n=1 )
     *           | 2*f(n-1),  (n>=2)
     */
    public static int jumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        return 2 * jumpFloor(target-1);
    }
    public static void main1(String[] args) {
        int ret = jumpFloor(5);
        System.out.println(ret);
    }
}
