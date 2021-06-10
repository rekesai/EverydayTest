import java.util.*;
class Sun{
    public int func(String str){
        return Integer.parseInt(str);
    }
}
class Earth extends Sun{
    public int func(int n){
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Sun().func("10"));
        System.out.println(new Earth().func(10));
        String str1 = "he" + "llo";
        String str2 = new String(str1);
        if(str1.equals(str2)){
            System.out.println(".equals success");
        }
        if(str1 == str2){
            System.out.println("== success");
        }
    }
}


public class Test14{



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/a5190a7c3ec045ce9273beebdfe029ee?f=discussion
     * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
     * 如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
     * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
     * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。
     * 现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
     * 输入描述:
     * 第一行输入一个正整数n(n ≤ 1000)
     * 第二行为n个数正整数xi(xi ≤ 1000)
     * 输出描述:
     * 输出可以产生的幸运的袋子数
     * 示例1
     * 输入
     * 3
     * 1 1 1
     * 输出
     * 2
     */
    public static int find(int[] nums, int index, int sum, int mul){
        int count = 0;
        for(int i = index; i < nums.length; i++) {
            sum += nums[i];
            mul *= nums[i];
            if(sum > mul)
                count += 1 + find(nums, i+1, sum, mul);
            else if(nums[i] == 1)
                count += find(nums, i+1, sum, mul);
            else
                break;
            sum -= nums[i];
            mul /= nums[i];
            while (i<nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
        return count;
    }
    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = s.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(find(nums, 0, 0, 1));
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/769d45d455fe40b385ba32f97e7bcded?answerType=1&f=discussion
     * 根据输入的日期，计算是这一年的第几天。
     * 输入描述:
     * 输入一行，每行空格分割，分别是年，月，日
     * 输出描述:
     * 输出是这一年的第几天
     * 示例1
     * 输入
     * 2012 12 31
     * 输出
     * 366
     * 示例2
     * 输入
     * 1982 3 4
     * 输出
     * 63
     */
    // 判断是否为闰年
    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int[] array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        if(year < 1 || month < 1 || month > 12 || day < 1 || day > array[month-1]){
            System.out.println(-1);
        }
        if(month == 2){
            if(isLeapYear(year) && day > 29 || !isLeapYear(year) && day > 28){
                System.out.println(-1);
            }
        }
        for(int i = 0; i < month-1; i++){
            days += array[i];
        }
        days += day;
        if(isLeapYear(year) && month > 2){
            days += 1;
        }
        System.out.println(days);
    }
}