import java.util.Scanner;
import java.util.Stack;

public class Test7 {


    //匹配括号问题：给定一个字符串和一个整数（字符串长度），判断这个字符串是否为合法的括号串，
    //括号串： 1、字符串只含括号  2、左括号和右括号要一一对应
    //https://exam.nowcoder.com/cts/17136880/summary?id=A73C60F60E6C1D26#4/{%22uid%22%3A%22A73C60F60E6C1D26%22%2C%22type%22%3A%224%22%2C%22index%22%3A1}
    public static boolean chkParenthesis(String A, int n) {
        //1、如果字符串为单数则直接返回false
        if(n % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = A.charAt(i);
            //每次为左括号入栈
            if(ch == '('){
                stack.push(ch);
            }
            //遇到右括号就出一个，如果栈为空返回false,否则出栈一个左括号
            else if(ch == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            //不是左右括号则不是括号串
            else{
                return false;
            }
        }
        //2、如果没有上面判断字符串单双数，则需要在此处判断栈是否为空，如果不为空则说明左括号多了，false
        if(!stack.isEmpty()){
            return false;
        }
        //当然也可以直接写return stack.isEmpty();如果为空则true, 如果不空则false
        return true;
    }
    public static void main(String[] args) {
        System.out.println(chkParenthesis("((())", 5));
    }


    //最小步数到斐波那契数列
    public void leastStepToFibonacci(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int f1 = 0;
        int f2 = 1;
        //当f2大于n时，n在f1和f2之间
        while(n > f2){
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        //求n到f1f2最小值
        int ret = Math.min((n - f1), (f2 - n));
        System.out.println(ret);
    }
}
