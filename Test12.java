import java.util.Scanner;

abstract class MyClass12{
    public int count = 5;
    public abstract void func(int a);
    public void func(){}


}
public class Test12 {
    public static void main(String[] args) throws java.io.FileNotFoundException{
        /*try{

        }
        catch (java.io.FileNotFoundException ex){

        }*/
        String str1 = "hello";
        String str2 = "he" + "llo";
        System.out.println(str1==str2);

    }
    // 给定两个int整数：n 和 m，令 m 的二进制形式，插入到 n 的二进制形式中的第 i 位到第 j 位
    // 位数的算法是从二进制低位到高位，且从0开始
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        m = m << j;
        return n | m;
    }


    //输入一个大于2的偶数，这个偶数可以被很多对儿素数相加而成，求这些对儿素数中，两个素数相差最小的一对
    //从中间向两边找
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0; i < n/2 - 1; i++){
            int num1 = n/2 - i;
            int num2 = n/2 + i;
            if(isPrime(num1) && isPrime(num2)){
                System.out.println(num1);
                System.out.println(num2);
                break;
            }
        }
    }
    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
