import java.util.Scanner;

public class Test28 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/184edec193864f0985ad2684fbc86841?toCommentId=9482839
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度大于2的子串重复
     *
     * 输入描述:
     * 一组或多组长度超过2的字符串。每组占一行
     *
     * 输出描述:
     * 如果符合要求输出：OK，否则输出NG
     *
     * 示例1
     * 输入
     * 021Abc9000
     * 021Abc9Abc1
     * 021ABC9000
     * 021$bc9000
     * 输出
     * OK
     * NG
     * NG
     * OK
     */
    public static Boolean checkPassword(String str){
        // 验证长度
        if(str.length() <= 8) return false;
        // 验证包括的字符种类
        int low = 0, up = 0, num = 0, other = 0;
        for(int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if(tmp >= 'a' && tmp <= 'z'){
                low = 1;
            }
            else if(tmp >= 'A' && tmp <= 'Z'){
                up = 1;
            }
            else if(tmp >= '0' && tmp <= '9'){
                num = 1;
            }
            else{
                other = 1;
            }
        }
        if(low+up+num+other < 3) return false;
        // 验证是否有长度大于2的子串重复
        for(int i = 0; i < str.length(); i++){
            for(int j = i+3; j < str.length(); j++){
                String tmp = str.substring(i, j);
                if(str.substring(j).contains(tmp)){
                    return false;
                }
            }
        }
        // 以上false都没有出现，返回true
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            if(checkPassword(str)){
                System.out.println("OK");
            }
            else{
                System.out.println("NG");
            }
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/99e403f8342b4d0e82f1c1395ba62d7b
     * 守形数是这样一种整数，它的平方的低位部分等于它本身。 比如25的平方是625，低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。
     *
     * 输入描述:
     * 输入包括1个整数N，2<=N<100。
     *
     * 输出描述:
     * 可能有多组测试数据，对于每组数据，
     * 输出"Yes!”表示N是守形数。
     * 输出"No!”表示N不是守形数。
     * 示例1
     * 输入
     * 25
     * 4
     * 输出
     * Yes!
     * No!
     */
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            String tmp = n + "";
            String tmpp = n*n + "";
            if(tmpp.substring(tmpp.length()-tmp.length()).equals(tmp)){
                System.out.println("Yes!");
            }
            else{
                System.out.println("No!");
            }
        }
    }

}
