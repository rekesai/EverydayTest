import java.util.Scanner;

public class Test20 {
    /**
     * 公共子串计算：输入两个字符串，输出两个字符串中最大的公共子串的长度
     * 链接：https://www.nowcoder.com/questionTerminal/98dc82c094e043ccb7e0570e5342dd1b
     * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
     *
     * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
     * 输入描述:
     * 输入两个只包含小写字母的字符串
     * 输出描述:
     * 输出一个整数，代表最大公共子串的长度
     * 示例1
     * 输入  asdfas
     *       werasdfaswer
     * 输出   6
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String l = str1.length()>=str2.length() ? str1:str2;
        String s = str1.length()>=str2.length() ? str2:str1;
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                String tmp = s.substring(i, j);
                if(l.contains(tmp) && tmp.length()>ret.length()){
                    ret = tmp;
                }
            }
        }
        System.out.println(ret.length());
    }

    /**
     * 输出逆序字符串
     * https://www.nowcoder.com/practice/e45e078701ab4e4cb49393ae30f1bb04?tpId=37&&tqId=21235&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
     * 描述
     * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     *
     * 输入描述：
     * 输入一行，为一个只包含小写字母的字符串。
     *
     * 输出描述：
     * 输出该字符串反转后的字符串。
     *
     * 示例1
     * 输入：  abcd
     * 输出：  dcba
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i = str.length()-1; i >= 0; i--){
            System.out.print(str.charAt(i));
        }
    }
}
