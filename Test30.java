import java.util.*;
public class Test30{

    /**
     *链接：https://www.nowcoder.com/questionTerminal/e8fb8f89f5d147ec92fd8ecfefe89b0d?f=discussion&toCommentId=9493713
     * 一个正整数可以分解成一个或多个数组的积。例如36=2*2*3*3，
     * 即包含2和3两个因子。NowCoder最近在研究因子个数的分布规律，
     * 现在给出一系列正整数，他希望你开发一个程序输出每个正整数的因子个数。
     *
     * 输入描述:
     * 输入包括多组数据。
     * 每组数据仅有一个整数n (2≤n≤100000)。
     * 输出描述:
     * 对应每个整数，输出其因子个数，每个结果占一行。
     * 示例1
     * 输入
     * 30
     * 26
     * 20
     * 输出
     * 3
     * 2
     * 2
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            int ret = 0;
            // 从2到你的平方根开始遍历因子
            for(int i = 2; i <= Math.sqrt(n); i++){
                // 碰到能整除的因子
                if(n % i == 0){
                    // 不断地除这个因子直到不能整除为止，因字数加一，开始下一次循环
                    while(n % i == 0){
                        n = n / i;
                    }
                    ret++;
                }
            }
            // 当循环结束n不为1，即没能整除，说明此时的n也是一个因子
            if(n != 1) ret++;
            System.out.println(ret);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9f6b8f6ec26d44cfb8fc8c664b0edb6b
     * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。
     * 假设你是军团中的一名军官，需要把发送来的消息破译出来、并提
     * 供给你的将军。
     * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换
     * （例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不变，并且消息原文的所有字母都是大写的。
     * 密码中的字母与原文中的字母对应关系如下。
     * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
     *
     * 输入描述:
     * 输入包括多组数据，每组数据一行，为收到的密文。
     * 密文仅有空格和大写字母组成。
     * 输出描述:
     * 对应每一组数据，输出解密后的明文。
     * 示例1
     * 输入
     * HELLO WORLD
     * SNHJ
     * 输出
     * CZGGJ RJMGY
     * NICE
     */
    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str = s.nextLine();
            for(int i = 0; i < str.length(); i++){
                char tmp = str.charAt(i);
                if(tmp >= 'F' && tmp <= 'Z'){
                    System.out.print((char)(tmp-5));
                }
                else if(tmp >= 'A' && tmp <= 'E'){
                    System.out.print((char)('Z'-('E'-tmp)));
                }
                else{
                    System.out.print(tmp);
                }
            }
            System.out.println();
        }
    }
    public static void main1(String[] args){
        String password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "VWXYZABCDEFGHIJKLMNOPQRSTU";
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String str = s.nextLine();
            for(int i = 0; i < str.length(); i++){
                char tmp = str.charAt(i);
                if(tmp == ' '){
                    System.out.print(' ');
                }
                else{
                    System.out.print(key.charAt(password.indexOf(tmp)));
                }
            }
            System.out.println();
        }
    }
}