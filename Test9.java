import java.util.Scanner;

public class Test9 {
    //要求不使用算术运算符表示两个数的相加
    public int addAB(int A, int B) {
        // write code here
        int s = A ^ B;
        int t = A & B;
        while(t != 0){
            int tmpA = s;
            int tmpB = t << 1;
            s = tmpA ^ tmpB;
            t = tmpA & tmpB;
        }
        return s;
    }


    //输入两个数字 n 和 m ，从左上角沿着边线走到右下角，只能向下或者向右走，问总共有几种走法
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int ret = func(n, m);
        System.out.println(ret);
    }
    public static int func(int a, int b){
        //当a和b都为0
        if(a == 0 && b == 0){
            return 0;
        }
        //当a为0b不为0 或者 a不为0b为0时
        else if(a == 0 || b == 0){
            return 1;
        }
        else{
            return func(a-1, b) + func(a, b-1);
        }
    }
}
