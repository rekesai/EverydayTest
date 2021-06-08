import java.util.*;
public class Test14{
    // 判断是否为闰年
    public static boolean isLeapYear(int year){
        if(year%400 == 0){
            return true;
        }
        else if(year%4 == 0 && year%100 != 0){
            return true;
        }
        return false;
    }
    // 计算每个月有多少天
    public static int mangDayOfMonth(int month, int year){
        if(month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12){
            return 31;
        }
        if(month == 2){
            if(isLeapYear(year)){
                return 29;
            }
            else{
                return 28;
            }
        }
        return 30;
    }
    // 判断是否合法
    public static boolean isLegal(int year, int month, int day){
        if(year < 1 || month < 1 || month > 12 || day < 1){
            return false;
        }
        if((month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12)
                && day > 31){
            return false;
        }
        if(month == 2){
            if(isLeapYear(year) && day > 29){
                return false;
            }
            if(!isLeapYear(year) && day > 28){
                return false;
            }
        }
        if((month == 4 || month == 6 || month == 9 || month == 11)
                && day > 30){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        if(isLegal(year, month, day)){
            System.out.println(-1);
        }
        else{
            int ret = 0;
            for(int i = 1; i < month; i++){
                ret += mangDayOfMonth(i, year);
            }
            ret += day;
            System.out.println(ret);
        }
    }
}