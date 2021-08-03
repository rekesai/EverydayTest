import java.util.*;
public class Test44{

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/81544a4989df4109b33c2d65037c5836
     * 单词倒排
     * 对字符串中的所有单词进行倒排。
     * 说明：
     * 1、构成单词的字符只有26个大写或小写英文字母；
     * 2、非构成单词的字符均视为单词间隔符；
     * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
     * 4、每个单词最长20个字母；
     *
     * 输入描述:
     * 输入一行以空格来分隔的句子
     * 输出描述:
     * 输出句子的逆序
     *
     * 示例1
     * 输入
     * I am a student
     * 输出
     * student a am I
     * 示例2
     * 输入
     * $bo*y gi!r#l
     * 输出
     * l r gi y bo
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) < 65 || str.charAt(i) > 90
                        && str.charAt(i) < 97 || str.charAt(i) > 122){
                    str = str.replace(str.charAt(i), ' ');
                }
            }
            String[] tmp = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = tmp.length-1; i >= 0; i--){
                if(i != 0){
                    sb.append(tmp[i]).append(" ");
                }
                else{
                    sb.append(tmp[i]);
                }
            }
            System.out.println(sb);
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/aed1c7bbc2604e7c9661a2348b0541b8?toCommentId=9630444
     * 骆驼命名法
     *
     * 从C/C++转到Java的程序员，一开始最不习惯的就是变量命名方式的改变。
     * C语言风格使用下划线分隔多个单词，例如“hello_world”；而Java则采用一种叫骆驼命名法的规则：
     * 除首个单词以外，所有单词的首字母大写，例如“helloWorld”。
     * 请你帮可怜的程序员们自动转换变量名。
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据一行，包含一个C语言风格的变量名。每个变量名长度不超过100。
     * 输出描述:
     * 对应每一组数据，输出变量名相应的骆驼命名法。
     * 示例1
     * 输入
     * hello_world
     * nice_to_meet_you
     * 输出
     * helloWorld
     * niceToMeetYou
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '_'){
                    System.out.print(str.charAt(++i)-32);
                }
                else if(i != str.length()-1){
                    System.out.print(str.charAt(i));
                }
                else{
                    System.out.println(str.charAt(i));
                }
            }
        }
    }
}