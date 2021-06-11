import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class A{
    public char a = 'A';
    public A(){
        System.out.println("我是A的构造方法");
    }
    public A(int a){
        System.out.println("我是A的带参数构造方法"+a);
    }
    public void funcA(){
        System.out.println("我是A的方法");
    }
}
class B extends A{
    public char b = 'B';
    public B(){
        System.out.println("我是B的构造方法");
    }
    public B(int b){
        System.out.println("我是B的带参数构造方法"+b);
    }
    public void funcB(){
        System.out.println("我是B的方法");
    }
}
/*class C extends B{
    public char c = 'C';
    public C(){
        super();
        System.out.println("我是C的构造方法");
    }
    public void funcC(){
        System.out.println("我是C的方法");
    }
}*/

abstract class MyClass{
    public int count = 9;
    public abstract void method(int a);
    public void method(){

    }
}
public class Test2 {
    public static void main(String[] args){
        Thread t = new Thread();
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a +" "+ b);
        int[] array = new int[2];
        System.out.println(array[2]);
    }
    public static void operator(StringBuffer a, StringBuffer b){
        a.append(b);
        b = a;
    }



    public static void reverse(String[] str){
        int left = 0;
        int right = str.length-1;
        while(left < right){
            String tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        String strIn = s.nextLine();
        String[] str = strIn.split(" ");
        reverse(str);
        for(int i = 0; i < str.length; i++){
            System.out.print(str[i]+" ");
        }
        int[] array = {1,2,3,4};
        Arrays.asList();
    }
}
