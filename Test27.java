import java.util.Scanner;

public class Test27 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     *
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     *
     * 本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
     *
     * 输入描述:
     * 输入
     * 1 输入IP地址
     * 2 输入10进制型的IP地址
     * 输出描述:
     * 输出
     * 1 输出转换成10进制的IP地址
     * 2 输出转换后的IP地址
     * 示例1
     * 输入
     * 10.0.3.193
     * 167969729
     * 输出
     * 167773121
     * 10.3.3.193
     */
    public static void ipToten(String ip){
        String[] str = ip.split("\\.");
        long n = Long.parseLong(str[0]);
        for(int i = 1; i < str.length; i++){
            n = n << 8;
            n += Long.parseLong(str[i]);
        }
        System.out.println(n);
    }
    public static void tenToip(String ten){
        long tmp = Long.parseLong(ten);
        String str = Long.toBinaryString(tmp);
        StringBuilder sb = new StringBuilder();
        if(str.length() < 32){
            for(int i = 0; i < 32-str.length(); i++){
                sb.append(0);
            }
        }
        sb.append(str);
        for(int i = 0; i < sb.length(); i+=8){
            if(i != 24){
                System.out.print(Integer.parseInt(sb.substring(i, i+8), 2)+".");
            }
            else{
                System.out.println(Integer.parseInt(sb.substring(i, i+8), 2));
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String ip = s.next();
            String ten = s.next();
            ipToten(ip);
            tenToip(ten);
        }
    }




    /**
     * 链接：https://www.nowcoder.com/questionTerminal/069e2130430c41229ab25e47fa0949a6
     * 输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。
     *
     * 输入描述:
     * 测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。
     *
     * 输出描述:
     * 对于每组输入,请输出结果。
     * 示例1
     * 输入
     * 2
     * 1 3
     * 0
     * 输出
     * -1
     */
    public static int findX(int[] nums, int x){
        for(int i = 0; i < nums.length; i++){
            if(x == nums[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = s.nextInt();
            }
            int x = s.nextInt();
            int ret = findX(nums, x);
            System.out.println(ret);
        }
    }
}