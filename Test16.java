import java.util.*;

public class Test16{
    /**
     *链接：https://acm.nowcoder.com/questionTerminal/0a92c75f5d6b4db28fcfa3e65e5c9b3f?answerType=1&amp;f=discussion
     *
     * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。
     * 牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
     * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
     *
     * 基本规则：
     * （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，
     *          不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
     * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系
     *          （如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
     * （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；
     *          顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
     * （4）输入的两手牌不会出现相等的情况。
     *
     * 答案提示：
     * （1）除了炸弹和对王之外，其他必须同类型比较。
     * （2）输入已经保证合法性，不用检查输入是否是合法的牌。
     * （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
     *
     * 输入描述:
     * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER。

     * 输出描述:
     * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
     *
     * 示例1
     * 输入
     * 4 4 4 4-joker JOKER
     * 输出
     * joker JOKER
     */
    // 将牌的大小顺序做成一个字符串，这个字符串必定包含 手牌的字符串
    // 比大小就是看 手牌字符串在这个顺序字符串中的小标
    public static int index(String str){
        return "345678910JQKA2jokerJOKER".indexOf(str);
    }
    public static int win(String str1, String str2){
        // 如果有对王的肯定最大
        if(str1.equals("joker JOKER")){
            return 0;
        }
        if(str2.equals("joker JOKER")){
            return 1;
        }
        // 将两手牌再通过空格分开
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        // 如果有一方是炸弹，一方不是，显而易见的输赢
        if(s1.length == 4 && s2.length != 4){
            return 0;
        }
        if(s1.length != 4 && s2.length == 4){
            return 1;
        }
        // 如果两手牌的长度一样说明规格一样，才能正式的比大小
        if(s1.length == s2.length){
            if(index(s1[0]) > index(s2[0])){
                return 0;
            }
            else{
                return 1;
            }
        }
        return -1;
    }


    /*public static int win(String str1, String str2){
        if(str1.equals("joker JOKER")){
            return 0;
        }
        if(str2.equals("joker JOKER")){
            return 1;
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("joker", 16);
        map.put("JOKER", 17);
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        if(s1.length == 4 && s2.length != 4){
            return 0;
        }
        if(s1.length != 4 && s2.length == 4){
            return 1;
        }
        if(s1.length == s2.length){
            if(map.get(s1[0]) > map.get(s2[0])){
                return 0;
            }
            else{
                return 1;
            }
        }
        return -1;
    }*/
    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] str = new String[2];
        // 将输入字符串分为 左手牌 和 右手牌
        str = input.split("-");
        // 比大小
        int ret = win(str[0], str[1]);
        if(ret == -1){
            System.out.println("ERROR");
        }
        else{
            System.out.println(str[ret]);
        }
    }


    /**
     *链接：https://www.nowcoder.com/questionTerminal/7299c12e6abb437c87ad3e712383ff84
     * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
     * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
     * 本题输入含有多组样例。
     * 输入描述:
     * 输入一个数字n
     * 输出描述:
     * 输出不超过n的完全数的个数
     * 示例1
     * 输入
     * 1000
     * 7
     * 100
     * 输出
     * 3
     * 1
     * 2
     */
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int n = s.nextInt();
            int count = 0;
            for(int i = 1; i <= n; i++){
                int sum = 0;
                for(int j = 1; j < i; j++){
                    if(i%j == 0){
                        sum += j;
                    }
                }
                if(sum == i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}