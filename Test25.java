import java.util.Scanner;

public class Test25 {
    /**
     * https://www.nowcoder.com/practice/e2422543519249f292d8435394ab82fe
     * 数根可以通过把一个数的各个位上的数字加起来得到。
     * 如果得到的数是一位数，那么这个数就是数根；如果结果是两位数或者包括更多位的数字，那么再把这些数字加起来。
     * 如此进行下去，直到得到是一位数为止。
     * 比如，对于24 来说，把2 和4 相加得到6，由于6 是一位数，因此6 是24 的数根。
     * 再比如39，把3 和9 加起来得到12，由于12 不是一位数，因此还得把1 和2 加起来，最后得到3，这是一个一位数，因此3 是39 的数根。
     * 现在给你一个正整数，输出它的数根。
     * 输入描述：
     * 输入包含多组数据。
     * 每组数据数据包含一个正整数n（1≤n≤10E1000）。
     * 输出描述：
     * 对应每一组数据，输出该正整数的数根。
     * 示例1
     * 输入：
     * 24
     * 39
     * 复制
     * 输出：
     * 6
     * 3
     */
    public static void main3(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str = s.next();
            int num = 0;
            for(int i = 0; i < str.length(); i++){
                num += str.charAt(i)-48;
            }
            while(num > 9){
                int sum = 0;
                while(num != 0){
                    sum += num % 10;
                    num = num /10;
                }
                num = sum;
            }
            System.out.println(num);
        }
    }
    // 优化
    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str = s.next();
            int num;
            do{
                num = 0;
                for(int i = 0; i < str.length(); i++){
                    num += str.charAt(i)-48;
                }
                str = num+"";
            }while(num > 9);
            System.out.println(num);
        }
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/34f17d5f2a8240bea661a23ec095a062
     * 星际战争开展了100年之后，NowCoder终于破译了外星人的密码！他们的密码是一串整数，通过一张表里的信息映射成最终4位密码。表的规则是：n对应的值是矩阵X的n次方的左上角，如果这个数不足4位则用0填充，如果大于4位的则只输出最后4位。
     * |1 1|^n => |Xn ..|
     * |1 0|      |.. ..|
     * 例如n=2时，
     * |1 1|^2 => |1 1| * |1 1| => |2 1|
     * |1 0|      |1 0|   |1 0|    |1 1|
     * 即2对应的数是“0002”。
     *
     * 输入描述:
     * 输入有多组数据。
     * 每组数据两行：第一行包含一个整数n (1≤n≤100)；第二行包含n个正整数Xi (1≤Xi≤10000)
     * 输出描述:
     * 对应每一组输入，输出一行相应的密码。
     * 示例1
     * 输入
     * 6
     * 18 15 21 13 25 27
     * 5
     * 1 10 100 1000 10000
     * 输出
     * 418109877711037713937811
     * 00010089410135017501
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] fib = new int[10000];
        fib[0] = 1;
        fib[1] = 2;
        for(int i = 2; i < 10000; i++){
            fib[i] = (fib[i-1] + fib[i-2])%10000;
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int tmp = sc.nextInt();
                String str = fib[tmp-1] + "";
                if(str.length() < 4){
                    for(int j = 0; j < 4-str.length(); j++){
                        System.out.print(0);
                    }
                }
                System.out.print(str);
            }
            System.out.println();
        }
    }
}