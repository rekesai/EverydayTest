import java.util.*;
public class Test31 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/0f6976af36324f8bab1ea61e9e826ef5?f=discussion
     * 所谓因子分解，就是把给定的正整数a，分解成若干个素数的乘积，即 a = a1 × a2 × a3 × ... × an,并且 1 < a1 ≤ a2 ≤ a3 ≤ ... ≤ an。其中a1、a2、...、an均为素数。 先给出一个整数a，请输出分解后的因子。
     *
     * 输入描述:
     * 输入包含多组数据，每组数据包含一个正整数a（2≤a≤1000000）。
     *
     * 输出描述:
     * 对应每组数据，以“a = a1 * a2 * a3...”的形式输出因式分解后的结果。
     * 示例1
     * 输入
     * 10<br/>18
     * 输出
     * 10 = 2 * 5<br/>18 = 2 * 3 * 3
     */
    public static void decompositionFactor1(int n){
        System.out.print(n+" = ");
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n != i){
                if(n % i == 0){
                    System.out.print(i+" * ");
                    n = n / i;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(n);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            decompositionFactor(n);
        }
    }

    public static void decompositionFactor(int n){
        int tmp = n;
        System.out.print(n+" = ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n/2; i++){
            while(tmp % i == 0){
                tmp = tmp / i;
                list.add(i);
            }
            if(tmp == 1){
                break;
            }
        }
        if(list.isEmpty()){
            System.out.println(n);
        }
        else{
            for(int i = 0; i < list.size(); i++){
                if(i != list.size()-1){
                    System.out.print(list.get(i)+" * ");
                }
                else{
                    System.out.println(list.get(i));
                }
            }
        }
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            decompositionFactor(n);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d95d98a2f96e49078cd7df84ba0c9d79?toCommentId=9505082
     * 和中国的节日不同，美国的节假日通常是选择某个月的第几个星期几这种形式，因此每一年的放假日期都不相同。具体规则如下：
     * * 1月1日：元旦
     * * 1月的第三个星期一：马丁·路德·金纪念日
     * * 2月的第三个星期一：总统节
     * * 5月的最后一个星期一：阵亡将士纪念日
     * * 7月4日：美国国庆
     * * 9月的第一个星期一：劳动节
     * * 11月的第四个星期四：感恩节
     * * 12月25日：圣诞节
     * 现在给出一个年份，请你帮忙生成当年节日的日期。
     *
     * 输入描述:
     * 输入包含多组数据，每组数据包含一个正整数year（2000≤year≤9999）。
     *
     * 输出描述:
     * 对应每一组数据，以“YYYY-MM-DD”格式输出当年所有的节日日期，每个日期占一行。
     *
     * 每组数据之后输出一个空行作为分隔。
     * 示例1
     * 输入
     * 2014
     * 2013
     * 输出
     * 2014-01-01
     * 2014-01-20
     * 2014-02-17
     * 2014-05-26
     * 2014-07-04
     * 2014-09-01
     * 2014-11-27
     * 2014-12-25
     *
     * 2013-01-01
     * 2013-01-21
     * 2013-02-18
     * 2013-05-27
     * 2013-07-04
     * 2013-09-02
     * 2013-11-28
     * 2013-12-25
     */
    // 根据 年-月-日 通过泰勒公式计算当前星期几
    public static int dayOfWeek(int year, int month, int day){
        if(month == 1 || month == 2){
            month += 12;
            year -= 1;
        }
        int century = year / 100;
        year = year % 100;
        int week = century / 4 - 2 * century + year + year / 4 + (13 * (month + 1)) / 5 + day - 1;
        week = (week % 7 + 7) % 7;
        if(week == 0){
            week = 7;
        }
        return week;
    }
    // 给定年月和第几周的星期几，求出是该月的几号几号
    public static int dayOfDemand(int year, int month, int count, int dOfWeek){
        int week = dayOfWeek(year, month, 1);// 计算该月1号是星期几
        // 1 + 7(n - 1) + (所求星期数 + 7 - 1号星期数) % 7
        int day = 1 + (count - 1) * 7 + (7 + dOfWeek - week) % 7;
        return day;
    }
    // 马丁·路德·金纪念日（1月的第3个星期1）
    public static void kingDay(int year){
        int day = dayOfDemand(year, 1, 3, 1);
        System.out.println(year+"-01-"+day);
    }
    // 总统日（2月的第3个星期1)
    public static void presidentDay(int year){
        int day = dayOfDemand(year, 2, 3, 1);
        System.out.println(year+"-02-"+day);
    }
    // 阵亡将士纪念日（5月的最后一个星期1）
    public static void generalDay(int year){
        // 从 6 月往前数
        int week = dayOfWeek(year, 6, 1);
        // 星期一的话，从 31 号往前数 6 天，否则，数 week - 2 天
        int day = 31 - ((week == 1) ? 6 : (week - 2));
        System.out.println(year+"-05-"+day);
    }
    // 劳动节（9月的第1个星期1）
    public static void laborDay(int year){
        int day = dayOfDemand(year, 9, 1, 1);
        System.out.println(year+"-09-0"+day);
    }
    // 感恩节（11月的第四个星期四）
    public static void thanksGiving(int year){
        int day = dayOfDemand(year, 11, 4, 4);
        System.out.println(year+"-11-"+day);
    }
    public static void americanFestivals(int year){
        System.out.println(year + "-01-01");
        kingDay(year);
        presidentDay(year);
        generalDay(year);
        System.out.println(year + "-07-04");
        laborDay(year);
        thanksGiving(year);
        System.out.println(year + "-12-25");
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            americanFestivals(year);
            System.out.println();
        }
    }
}
