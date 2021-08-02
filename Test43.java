import java.util.*;

public class Test43 {

    /**
     * 求和牛客
     * 链接：https://www.nowcoder.com/questionTerminal/11cc498832db489786f8a03c3b67d02c?toCommentId=9620378
     *
     * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
     * 输入描述:
     * 每个测试输入包含2个整数,n和m
     *
     * 输出描述:
     * 按每个组合的字典序排列输出,每行输出一种组合
     * 示例1
     * 输入
     * 5 5
     * 输出
     * 1 4
     * 2 3
     * 5
     */
    public static void dfs(int i, int n , int m, ArrayList<Integer> list){
        if(m == 0){
            for(int j = 0; j < list.size(); j++){
                if(j != list.size()-1){
                    System.out.print(list.get(j) + " ");
                }
                else{
                    System.out.println(list.get(j));
                }
            }
        }
        else{
            for(int j = i+1; j <= n; j++){
                list.add(j);
                dfs(j, n, m-j, list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
            dfs(i, n, m-i, list);
            list.remove(list.size()-1);
        }
    }

    /**
     * 电话号码牛客
     * 链接：https://www.nowcoder.com/questionTerminal/ceb89f19187b4de3997d9cdef2d551e8
     * 上图是一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。
     * 例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。
     * 同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
     * NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。
     *
     * 输入描述:
     * 输入包含多组数据。
     *
     * 每组数据第一行包含一个正整数n（1≤n≤1024）。
     *
     * 紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
     * 没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。
     *
     * 输出描述:
     * 对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。
     * 每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
     * 示例1
     * 输入
     * 12
     * 4873279
     * ITS-EASY
     * 888-4567
     * 3-10-10-10
     * 888-GLOP
     * TUT-GLOP
     * 967-11-11
     * 310-GINO
     * F101010
     * 888-1200
     * -4-8-7-3-2-7-9-
     * 487-3279
     * 4
     * UTT-HELP
     * TUT-GLOP
     * 310-GINO
     * 000-1213
     * 输出
     * 310-1010
     * 310-4466
     * 487-3279
     * 888-1200
     * 888-4567
     * 967-1111
     *
     * 000-1213
     * 310-4466
     * 888-4357
     * 888-4567
     */
    static String str = "22233344455566677778889999";
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num = sc.nextLine();
            int n = Integer.parseInt(num);
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String tmp = sc.nextLine();
                tmp = tmp.replaceAll("-", "");
                if(tmp.length() != 7) continue;
                for(int j = 0; j < tmp.length(); j++){
                    if(tmp.charAt(j) >= 'A' && tmp.charAt(j) <= 'Z'){
                        tmp = tmp.replace(tmp.charAt(j), str.charAt(tmp.charAt(j)-65));
                    }
                }
                if(!list.contains(tmp)) list.add(tmp);
            }
            Collections.sort(list);
            for(String s :list){
                System.out.println(s.substring(0, 3)+"-"+s.substring(3));
            }
            System.out.println();
        }
    }
}