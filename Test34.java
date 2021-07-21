import java.util.*;
import java.math.*;
public class Test34{
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/71d3849a19f04a1591c415964ac148f1
     * 一只成熟的兔子每天能产下一胎兔子。每只小兔子的成熟期是一天。 某人领养了一只小兔子，请问第N天以后，他将会得到多少只兔子。
     * 输入描述:
     * 测试数据包括多组，每组一行，为整数n(1≤n≤90)。
     *
     * 输出描述:
     * 对应输出第n天有几只兔子(假设没有兔子死亡现象)。
     * 示例1
     * 输入
     * 1<br/>2
     * 输出
     * 1<br/>2
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fib = new BigInteger[90];
        fib[0] = new BigInteger("1");
        fib[1] = new BigInteger("2");
        for(int i = 2; i < 90; i++){
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(fib[n-1]);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/5973a31d58234b068fa1fe34f7290855?toCommentId=9529113
     * NowCoder每天要给许多客户写电子邮件。正如你所知，如果一封邮件中包含多个收件人，收件人姓名之间会用一个逗号和空格隔开；
     * 如果收件人姓名也包含空格或逗号，则姓名需要用双引号包含。
     * 现在给你一组收件人姓名，请你帮他生成相应的收件人列表。
     *
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据的第一行是一个整数n (1≤n≤128)，表示后面有n个姓名。
     * 紧接着n行，每一行包含一个收件人的姓名。姓名长度不超过16个字符。
     *
     * 输出描述:
     * 对应每一组输入，输出一行收件人列表。
     * 示例1
     * 输入
     * 3
     * Joe
     * Quan, William
     * Letendre,Bruce
     * 2
     * Leon
     * Kewell
     * 输出
     * Joe, "Quan, William", "Letendre,Bruce"
     * Leon, Kewell
     */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextLine();
                if(s[i].contains(" ") || s[i].contains(",")){
                    s[i] = "\"" + s[i] + "\"";
                }
            }
            for(int i = 0; i < n; i++){
                if(i == n-1){
                    System.out.println(s[i]);
                }
                else{
                    System.out.print(s[i]+", ");
                }
            }
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextLine();
            }
            for(int i = 0; i < n; i++){
                if(s[i].contains(" ") || s[i].contains(",")){
                    if(i == n-1){
                        System.out.println("\"" + s[i] + "\"");
                    }
                    else{
                        System.out.print("\"" + s[i] + "\", ");
                    }
                }
                else{
                    if(i == n-1){
                        System.out.println(s[i]);
                    }
                    else{
                        System.out.print(s[i] + ", ");
                    }
                }
            }
        }
    }
}