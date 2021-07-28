import java.util.Scanner;

public class Test39 {
    /**
     * 我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。子串中的字符不一定在原字符串中连续。
     * 例如字符串“abcfbc”和“abfcab”，其中“abc”同时出现在两个字符串中，因此“abc”是它们的公共子序列。
     * 此外，“ab”、“af”等都是它们的字串。
     * 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
     * 输出描述:
     * 对应每组输入，输出最长公共子序列的长度。
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            int dp[][] = new int[s1.length()+1][s2.length()+1];
            for(int i = 0; i < s1.length(); i++){
                for(int j = 0; j < s2.length(); j++){
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i+1][j+1] = dp[i][j]+1;
                    }
                    else{
                        dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);
        }
    }
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f72adfe389b84da7a4986bde2a886ec3?f=discussion
     * 求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。
     * 输入描述:
     * 每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）
     * 输出描述:
     * 输出答案。
     * 示例1
     * 输入
     * ab ce 1 2
     * 输出
     * 56
     */
    public static void main1(String []args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long result = 0;
            String s1 = sc.next();
            String s2 = sc.next();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            for(int i = 0; i < s1.length(); i++){
                int distance = s2.charAt(i)-s1.charAt(i);
                long tmp = 0;
                for(int j = len1; j <= len2; j++){
                    if(j-i-1 >= 0){
                        tmp = tmp + (long)Math.pow(26, j-i-1);
                    }
                }
                tmp = (tmp*distance) % 1000007;
                result += tmp;
            }
            System.out.println(result-1);
        }
    }
}