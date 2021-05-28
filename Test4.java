import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
    /*
    * 小易去买苹果，却发现奸商捆绑出售，只卖6个一袋或者8个一袋
    * 小易却只想买n个苹果，尽量用最少的袋数来装
    * 输入描述：输入一个整数 n 表示小易想买的苹果个数    1 <= n <= 100
    * 输出描述：输出一个整数表示最少需要购买的袋数，如果不能恰好购买n个苹果，小易就不买了，输出-1
    * */
    public int apple(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int j = n/8;
        while(j >= 0){
            if((n-8*j)%6 == 0){
                break;
            }
            j--;
        }
        int i = (n-8*j) / 6;
        if(i*6 + j*8 == n){
            return i+j;
        }
        else{
            return -1;
        }
    }


    /*
    *输入两个字符串，如果第一个字符串中包含第二个字符串中的字符就将其删去
    * 最后输出不包含字符串2的部分
    * */
    public void removeContains(){
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        ArrayList<Character> list1 = new ArrayList<>();
        for(int i = 0; i < str2.length(); i++){
            list1.add(str2.charAt(i));
        }
        for(int i = 0; i < str1.length(); i++){
            if(!list1.contains(str1.charAt(i))){
                System.out.print(str1.charAt(i));
            }
        }
    }


    /*
    链接：https://www.nowcoder.com/questionTerminal/02d8d42b197646a5bbd0a98785bb3a34
    A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
    A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
    现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
    输入描述:
    输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
    输出描述:
    输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No
    示例1
    输入
    1 -2 3 4
    输出
    2 1 3
    */
    public void candy(){
        Scanner s = new Scanner(System.in);
        int i1 = s.nextInt();
        int i2 = s.nextInt();
        int i3 = s.nextInt();
        int i4 = s.nextInt();
        int a = (i1 + i3)/2;
        int b = (i2 + i4)/2;
        int c = (i4 - i2)/2;
        if(a-b == i1 && b-c == i2 && a+b == i3 && b+c == i4){
            System.out.print(a+" ");
            System.out.print(b+" ");
            System.out.print(c);
        }
        else{
            System.out.println("No");
        }
    }


    /*
    * 链接：https://www.nowcoder.com/questionTerminal/ac61207721a34b74b06597fe6eb67c52
    * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
    * 输入描述:输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
    * 输出描述:为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
    * 示例1
    * 输入
    * 7 2
    * 输出
    * 111
    *       当商为零时结束循环
    *       7 / 2 = 3; 7 % 2 = 1;
    *       3 / 2 = 1; 3 % 2 = 1;
    *       1 / 2 = 0; 1 % 2 = 1;
    * */
    public void baseConversion( ){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        //定义顺序表来存放每次算出的值
        ArrayList<Integer> list = new ArrayList<>();
        //定义一个临时变量num用来放m，方便使用，如果m为负，就将它变为正的，既方便运算，也利于后面对于m的判断
        int num = m;
        if(m < 0){
            num = -m;
        }
        //循环num来进行运算，每次都将余数加入顺序表中，并在num上直接运算除n，当商为0时结束循环
        while(num != 0){
            int remainder = num % n;
            list.add(remainder);
            num = num / n;
        }
        //判断m是否为负数，如果是就先输出一个‘-’ 负号（m是没变的，变得是m的替身num）
        if(m < 0){
            System.out.print('-');
        }
        //循环顺序表，倒着输出，如果大于等于10就得按照十六进制的方法来将10,11,12,13,14,15，变成相应的A,B,C,D,E,F
        for(int i = list.size()-1; i >= 0; i--){
            if(list.get(i) >= 10){
                //字符运算会变成int类型，如果将int转化为char类型会有风险，所以要强转
                char ch = (char)('A'+list.get(i)-10);
                System.out.print(ch);
            }
            else{
                System.out.print(list.get(i));
            }
        }
    }

    public void baseConversion2(){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        //定义一个StringBuilder来进行字符串拼接，最后输出就是了
        StringBuilder str = new StringBuilder();
        int num = m;
        if(m < 0){
            num = -m;
        }
        while(num != 0){
            int remainder = num % n;
            if(remainder >= 10){
                //要强转int为char，因为字符参与运算就变成了int类型了
                char ch = (char)(remainder-10 + 'A');
                //用append将字符拼接起来变成字符串
                str.append(ch);
            }
            else{
                str.append(remainder);
            }
            num = num/n;
        }
        if(m < 0){
            System.out.print('-');
        }
        //将拼接好的字符串逆序输出
        System.out.print(str.reverse());
    }
}
