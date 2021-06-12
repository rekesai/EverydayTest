import java.util.*;

class Sv{
    public String str = "6";
    public void change(String str){
        str = "10";
    }
    public static void main(String[] args) {
        Sv sv = new Sv();
        sv.change(sv.str);
        System.out.println(sv.str);
    }
}
public class Test18{
    /**
     *链接：https://www.nowcoder.com/questionTerminal/43072d50a6eb44d2a6c816a283b02036?answerType=1&f=discussion
     * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
     * 要求：
     * 实现如下2个通配符：
     * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，下同）
     * ？：匹配1个字符
     * 注意：匹配时不区分大小写。
     * 输入：
     * 通配符表达式；
     * 一组字符串。
     * 输出：
     * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
     * 本题含有多组样例输入！
     * 输入描述:
     * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
     * 输出描述:
     * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
     * 示例1
     * 输入
     * te?t*.*
     * txt12.xls
     * 输出
     * false
     * 示例2
     * 输入
     * z
     * zz
     * 输出
     * false
     * 示例3
     * 输入
     * pq
     * pppq
     * 输出
     * false
     * 示例4
     * 输入
     * **Z
     * 0QZz
     * 输出
     * true
     * 示例5
     * 输入
     * ?*Bc*?
     * abcd
     * 输出
     * true
     * 示例6
     * 输入
     * p*p*qp**pq*p**p***ppq
     * pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp
     * 输出
     * false
     */
    // 正则表达式，云里雾里
    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String regx = s.nextLine();
            String str = s.nextLine();
            regx = regx.replaceAll("\\?", "[a-zA-Z0-9]{1}");
            regx = regx.replaceAll("\\*", "[a-zA-Z0-9]{0,}");
            boolean result = str.matches(regx);
            System.out.println(result);
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1221ec77125d4370833fd3ad5ba72395
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子
     * 假如兔子都不死，问每个月的兔子总数为多少？
     * 本题有多组数据。
     * 输入描述:
     * 输入int型表示month
     * 输出描述:
     * 输出兔子总数int型
     * 示例1
     * 输入
     * 9
     * 输出
     * 34
     */
    // 类似于斐波那契数列，举例写一下便知
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int month = s.nextInt();
            int a = 1;
            int b = 0;
            int c = 0;
            while(--month != 0){
                c += b;
                b = a;
                a = c;
            }
            System.out.println(a+b+c);
        }
    }
}