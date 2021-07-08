import java.util.*;
public class Test22{
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        for(int i : array){
            System.out.print(i+" ");
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fe6c73cb899c4fe1bdd773f8d3b42c3d
     * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.
     * 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
     * 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;
     * 如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
     * 输入描述:
     * 对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
     * 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
     * 输出描述:
     * 对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值
     * 示例1
     * 输入
     * 3 50
     * 50 105 200
     * 5 20
     * 30 20 15 40 100
     * 输出
     * 110
     * 205
     */
    // 求最大公约数
    public static int commonDivisor(int x, int y){
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        while(max % min != 0){
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return min;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            for(int i = 0; i < n; i++){
                int value = sc.nextInt();
                if (a >= value) {
                    a += value;
                } else {
                    a += commonDivisor(a, value);
                }
            }
            System.out.println(a);
        }
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/e896d0f82f1246a3aa7b232ce38029d4
     * 找出字符串中第一个只出现一次的字符
     * 输入描述:
     * 输入几个非空字符串
     * 输出描述:
     * 输出第一个只出现一次的字符，如果不存在输出-1
     * 示例1
     * 输入
     * asdfasdfo
     * aabb
     * 输出
     * o
     * -1
     */
    // 优化后
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            boolean flg = true;
            for(int i = 0; i < str.length(); i++){
                if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                    System.out.println(str.charAt(i));
                    flg = false;
                    break;
                }
            }
            if(flg){
                System.out.println(-1);
            }
        }
    }
    // 优化前
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] ch = sc.next().toCharArray();
            char[] ch2 = new char[ch.length];
            for(int i = 0; i < ch.length; i++){
                ch2[i] = ch[i];
            }
            boolean flg = true;
            for(int i = 0; i < ch.length; i++){
                int k = 0;
                for(int j = 0; j < ch2.length; j++){
                    if(ch[i] == ch2[j]){
                        k++;
                    }
                }
                if(k == 1){
                    System.out.println(ch[i]);
                    flg = false;
                    break;
                }
            }
            if(flg){
                System.out.println(-1);
            }
        }
    }
}
