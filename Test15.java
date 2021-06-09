import java.util.*;
public class Test15{





    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1b46eb4cf3fa49b9965ac3c2c1caf5ad?commentTags=Python
     * 输入一个正整数，计算它在二进制下的1的个数。
     * 注意多组输入输出！！！！！！
     * 输入描述:
     * 输入一个整数
     * 输出描述:
     * 计算整数二进制中1的个数
     * 示例1
     * 输入
     * 5
     * 输出
     * 2
     * 说明
     * 5的二进制表示是101，有2个1
     */
    public static int findNumberOf1(int num){
        int count = 0;
        boolean flag = true;
        if(num < 0){
            num = -num;
            flag = false;
        }
        while(num != 0){
            if((num&1) == 1){
                count++;
            }
            num = num >>> 1;
        }
        if(!flag){
            count += 1;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int num = s. nextInt();
            int ret = findNumberOf1(num);
            System.out.println(ret);
        }
    }
}