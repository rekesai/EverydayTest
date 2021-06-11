import java.util.Scanner;

abstract class MyClass11{
    public int count = 5;
    public abstract void func(int a);
    public void func(){}

}
public class Test11 {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1==str2);
    }

    //输入一个byte型数字，求其二进制数字中1的最大连续数，如输入3，输出2
    public static void main1(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        byte n = s.nextByte();
        int i = n;
        int count = 0;
        int max = 0;
        while(i != 0){
            int tmp = i & 1;
            if(tmp == 1){
                count++;
            }
            else{
                count = 0;
            }
            max = Math.max(max, count);
            i = i >>> 1;
        }
        System.out.println(max);
    }



    //有一个无穷大的满二叉树，从根节点开始编号为1，从上至下，从左至右编号
    //现在输入两个数字a  b  代表两个节点编号，求出他们的最小的公共祖先节点编号
    public int getLCA(int a, int b) {
        //既然是求最近的公共祖先节点，那就让他们谁大谁就除2，就能得出谁的父节点
        //如此循环，当两个数字求到的父节点一样时就得出了最小的公共祖先节点，不放画图试试看
        while(a != b){
            if(a > b){
                a = a/2;
            }
            else{
                b = b/2;
            }
        }
        return a;
    }


}
