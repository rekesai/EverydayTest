import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Test33 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/3549ff22ae2c4da4890e9ad0ccb6150d?toCommentId=9528005
     * 来源：牛客网
     *
     * NowCoder开了一家早餐店，这家店的客人都有个奇怪的癖好：他们只要来这家店吃过一次早餐，就会每天都过来；
     * 并且，所有人在这家店吃了两天早餐后，接下来每天都会带一位新朋友一起来品尝。
     * 于是，这家店的客人从最初一个人发展成浩浩荡荡成百上千人：1、1、2、3、5……
     * 现在，NowCoder想请你帮忙统计一下，某一段时间范围那他总共卖出多少份早餐（假设每位客人只吃一份早餐）。
     *
     * 输入描述:
     * 测试数据包括多组。
     * 每组数据包含两个整数from和to(1≤from≤to≤80)，分别代表开店的第from天和第to天。
     *
     * 输出描述:
     * 对应每一组输入，输出从from到to这些天里（包含from和to两天），需要做多少份早餐。
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] fib = new BigInteger[80];
        fib[0] = new BigInteger("1");
        fib[1] = new BigInteger("1");
        for(int i = 2; i < 80; i++){
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        while(sc.hasNext()){
            int from = sc.nextInt();
            int to = sc.nextInt();
            BigInteger count = new BigInteger("0");
            for(int i = from-1; i < to; i++){
                count = count.add(fib[i]);
            }
            System.out.println(count);
        }
    }


    public static void main3(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<BigInteger> fib = new ArrayList<>();
        fib.add(new BigInteger("1"));
        fib.add(new BigInteger("1"));
        for(int i = 2; i < 80; i++){
            fib.add(fib.get(i-1).add(fib.get(i-2)));
        }
        while(sc.hasNext()){
            int from = sc.nextInt();
            int to = sc.nextInt();
            BigInteger count = new BigInteger("0");
            for(int i = from-1; i < to; i++){
                count.add(fib.get(i));
            }
            System.out.println(count);
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1046cd038f7a4b04b2b77b415973de1c
     * 一块花布条，里面有些图案，另有一块直接可用的小饰条，里面也有一些图案。
     * 对于给定的花布条和小饰条，计算一下能从花布条中尽可能剪出几块小饰条来呢？
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据包含两个字符串s,t，分别是成对出现的花布条和小饰条
     * 其布条都是用可见ASCII字符表示的，可见的ASCII字符有多少个，布条的花纹也有多少种花样。
     * 花纹条和小饰条不会超过1000个字符长。
     *
     * 输出描述:
     * 对应每组输入，输出能从花纹布中剪出的最多小饰条个数，如果一块都没有，那就输出0，每个结果占一行。
     * 示例1
     * 输入
     * abcde a3
     * aaaaaa aa
     * 输出
     * 0
     * 3
     */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String t = sc.next();
            int count = 0;
            if(!s.contains(t)){
                System.out.println(count);
            }
            else{
                while(s.contains(t)){
                    int i = 0;
                    for(i = 0; i < s.length(); i++){
                        if(s.charAt(i) == t.charAt(0)) break;
                    }
                    if(s.substring(i, i+t.length()).equals(t)){
                        count++;
                        s = s.substring(i+t.length());
                    }
                }
                System.out.println(count);
            }
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            String t = sc.next();
            int count = 0;
            while(s.contains(t)){
                s = s.replaceFirst(t, "");
                count++;
            }
            System.out.println(count);
        }
    }
}
