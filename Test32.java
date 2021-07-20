import java.util.Scanner;
public class Test32 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c0a4b917a15f40a49ca10532ab9019fb
     * NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
     * 为了考验他，我们随便出一个数n，让他说出第n个斐波那契数。当然，斐波那契数会很大。因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位。
     *
     * 输入描述:
     * 输入有多组数据。
     * 每组数据一行，包含一个整数n (1≤n≤100000)。
     * 输出描述:
     * 对应每一组输入，输出第n个斐波那契数的最后6位。
     * 示例1
     * 输入
     * 1
     * 2
     * 3
     * 4
     * 100000
     * 输出
     * 1
     * 2
     * 3
     * 5
     * 537501
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] fib = new int[100001];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < fib.length; i++){
            fib[i] = (fib[i-1]+fib[i-2])%1000000;
        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.printf((n<25 ? "%d\n":"%06d\n"), fib[n]);
        }
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/754921e9c98b43d1b2d70c227b844101?toCommentId=9521318
     * NowCoder在淘宝上开了一家网店。他发现在月份为素数的时候，当月每天能赚1元；否则每天能赚2元。
     * 现在给你一段时间区间，请你帮他计算总收益有多少。
     *
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据包含两个日期from和to (2000-01-01 ≤ from ≤ to ≤ 2999-12-31)。
     * 日期用三个正整数表示，用空格隔开：year month day。
     *
     * 输出描述:
     * 对应每一组数据，输出在给定的日期范围（包含开始和结束日期）内能赚多少钱。
     * 示例1
     * 输入
     * 2000 1 1 2000 1 31
     * 2000 2 1 2000 2 29
     * 输出
     * 62
     * 29
     */
    // 平年一年每个月份的收入
    static int[] moneyOfMonth = {62, 28, 31, 60, 31, 60, 31, 62, 60, 62, 30, 62};
    // 判断闰年
    public static boolean isLeap(int year){
        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
    // 判断素数月
    public static boolean isPrime(int month){
        if(month == 2 || month == 3 || month == 5 || month == 7 || month == 11) return true;
        return false;
    }
    // 计算完整一年的收入
    public static int moneyOfYear(int year){
        int ret = 0;
        for(int i = 0; i < moneyOfMonth.length; i++){
            ret += moneyOfMonth[i];
        }
        if(isLeap(year)){
            return ret+1;
        }
        return ret;
    }

    // 计算同年收入
    public static int moneyOfIncompleteYear(int[] from, int[] to){
        // 同月
        if(from[1] == to[1]){
            if(isPrime(from[1])){
                return to[2]-from[2]+1;
            }
            else{
                return 2*(to[2]-from[2]+1);
            }
        }
        int ret = 0;
        // 1.计算from月收入
        if(isPrime(from[1])){
            ret += moneyOfMonth[from[1]-1] - (from[2]-1);
        }
        else{
            ret += moneyOfMonth[from[1]-1] - 2*(from[2]-1);
        }
        if(from[1] == 2 && isLeap(from[0])) ret++;
        // 2.计算从from当月的下一月到to的前一月这几月完整的月收入
        for(int i = from[1]+1-1; i < to[1]-1; i++){
            ret += moneyOfMonth[i];
            if(i == 2 && isLeap(from[0])) ret++;
        }
        // 3.计算to月收入
        if(isPrime(to[1])){
            ret += to[2];
        }
        else{
            ret += 2*to[2];
        }
        return ret;
    }
    // 计算从from到to的收入
    public static int money(int[] from, int[] to){
        // 同年
        if(from[0] == to[0]){
            return moneyOfIncompleteYear(from, to);
        }
        int ret = 0;
        // 1.计算from当年的收入
        if(isPrime(from[1])){
            ret += moneyOfMonth[from[1]-1] - from[2]-1;
        }
        else{
            ret += moneyOfMonth[from[1]-1] - 2*(from[2]-1);
        }
        if(from[1] == 2 && isLeap(from[0])) ret++;
        for(int i = from[1]+1-1; i < 12; i++){//+1是因为要计算的后一个月的 -1是因为数组下标
            ret += moneyOfMonth[i];
            if(i == 1 && isLeap(from[0])) ret++;
        }
        // 2.计算从from当年的下一年到to的前一年这几年完整的年收入
        for(int i = from[0]+1; i < to[0]; i++){
            ret += moneyOfYear(i);
        }
        // 3.计算to当年收入
        for(int i = 0; i < to[1]-1; i++){
            ret += moneyOfMonth[i];
            if(i == 1 && isLeap(to[0])) ret++;
        }
        if(isPrime(to[1])){
            ret += to[2];
        }
        else{
            ret += 2*to[2];
        }
        return ret;
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] from = new int[3];
            for(int i = 0; i < 3; i++){
                from[i] = sc.nextInt();
            }
            int[] to = new int[3];
            for(int i = 0; i < 3; i++){
                to[i] = sc.nextInt();
            }
            int ret = money(from, to);
            System.out.println(ret);
        }
    }
}