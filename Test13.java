import java.util.ArrayList;
import java.util.Scanner;


abstract class Animal{
    abstract void say();
}
class Cat extends Animal{
    @Override
    public void say(){
        System.out.println("cat say meow meow");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.say();
    }
}

public class Test13 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/4284c8f466814870bae7799a07d49ec8
     * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
     * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
     * 例如：
     * N = 4，M = 24：
     * 4->6->8->12->18->24
     * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
     * 输入描述:
     * 输入为一行，有两个整数N，M，以空格隔开。 (4 ≤ N ≤ 100000) (N ≤ M ≤ 100000)
     * 输出描述:
     * 输出小易最少需要跳跃的步数,如果不能到达输出-1
     * 示例1
     * 输入
     * 4 24
     * 输出
     * 5
     */
    //算法复杂度过大
    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> divisor(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i < n; i++){
            if(n%i == 0){
                list.add(i);
            }
        }
        return list;
    }
    public static int func(int n, int m){
        int commonDivisor = 0;
        int count = 0;
        while(n < m){
            ArrayList<Integer> list = divisor(n);
            int tmp = list.get(list.size()-1);
            if(m-n > tmp){
                n += tmp;
                count++;
            }
            else{
                for(int i = 0; i < list.size(); i++){
                    if(m-n == list.get(i)){
                        n += list.get(i);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(isPrime(n) || isPrime(m)){
            System.out.println(-1);
        }
        else{
            int ret = func(n, m);
            System.out.println(ret);
        }
    }


    /**
     *链接：https://www.nowcoder.com/questionTerminal/668603dc307e4ef4bb07bcd0615ea677
     * 在命令行输入如下命令：
     * xcopy /s c:\ d:\，
     * 各个参数如下：
     * 参数1：命令字xcopy
     * 参数2：字符串/s
     * 参数3：字符串c:\
     * 参数4: 字符串d:\
     * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
     * 解析规则：
     * 1.参数分隔符为空格
     * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
     * 3.参数不定长
     * 4.输入由用例保证，不会出现不符合要求的输入
     * 输入描述:
     * 输入一行字符串，可以有空格
     * 输出描述:
     * 输出参数个数，分解后的参数，每个参数都独占一行
     * 示例1
     * 输入
     * xcopy /s c:\\ d:\\
     * 输出
     * 4
     * xcopy
     * /s
     * c:\\
     * d:\\
     */
    // xcopy /s "C:\program files" "d:\"
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        //创建一个顺序表，这个顺序表的每一个节点是一个字符类型的顺序表
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        int i = 0;
        //开始大循环
        while(i < str.length()){
            //创建每一次放入 list 的 字符型顺序表
            ArrayList<Character> listTmp = new ArrayList<>();
            //当 str.charAt(i) 不为空格时进入循环
            while(i < str.length() && str.charAt(i) != ' '){
                //如果 str.charAt(i) 不为 " ,则直接加入listTmp
                if(str.charAt(i) != '"'){
                    listTmp.add(str.charAt(i));
                }
                //如果str.charAt(i) 为 "
                else{
                    //跳过字符为 " 的下标
                    i++;
                    //此时的i下标的字符则为字符 " 之后的第一个字符，当不遇到第二个 " 的情况下，通通加入到listTmp中
                    while(i < str.length() && str.charAt(i) != '"'){
                        listTmp.add(str.charAt(i));
                        i++;
                    }
                }
                // 走到这里i++有两个原因
                // 1、if直接加入字符了需要i++来判断下一个字符
                // 2、else中的while遇到第二个字符 " 跳出循环，此时i下标的字符为第二个 " 所以i++
                i++;
            }
            //将上面放好的一个字符类型的顺序表加入到list中
            list.add(listTmp);
            i++;
        }
        System.out.println(list.size());
        for (ArrayList<Character> charList : list) {
            for (Character ch : charList) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
