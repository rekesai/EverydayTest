import java.util.ArrayList;
import java.util.Scanner;

public class Test35 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/286af664b17243deb745f69138f8a800?orderByHotValue=1&done=0&pos=236&mutiTagIds=579&onlyReference=false
     * NowCoder每天要处理许多邮件，但他并不是在收件人列表中，有时候只是被抄送。
     * 他认为这些抄送的邮件重要性比自己在收件人列表里的邮件低，因此他要过滤掉这些次要的邮件，优先处理重要的邮件。
     * 现在给你一串抄送列表，请你判断目标用户是否在抄送列表中。
     *
     * 输入描述:
     * 输入有多组数据，每组数据有两行。
     * 第一行抄送列表，姓名之间用一个逗号隔开。如果姓名中包含空格或逗号，则姓名包含在双引号里。总长度不超过512个字符。
     * 第二行只包含一个姓名，是待查找的用户的名字（姓名要完全匹配）。长度不超过16个字符。
     *
     * 输出描述:
     * 如果第二行的名字出现在收件人列表中，则输出“Ignore”，表示这封邮件不重要；否则，输出“Important!”，表示这封邮件需要被优先处理。
     * 示例1
     * 输入
     * Joe,Kewell,Leon
     * Joe
     * "Letendre, Bruce",Joe,"Quan, William"
     * William
     * 输出
     * Ignore
     * Important!
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String name = sc.nextLine();
            char[] ch = s.toCharArray();
            ArrayList<String> list = new ArrayList<>();
            int flag = 0;
            String res = "";
            for (int i = 0; i < ch.length; i ++ ) {
                if(flag == 0 && ch[i] == '"') {
                    flag = 1;
                    list.add(res);
                    res = "";
                } else if(flag == 1 && ch[i] == '"') {
                    flag = 0;
                    list.add(res);
                    res = "";
                } else if(flag == 1) {
                    res += ch[i];
                } else if(flag == 0 && ch[i] != ',') {
                    res += ch[i];
                }
            }
            list.add(res);
            boolean flg = true;
            for(String str : list){
                if(str.equals(name)){
                    flg = false;
                }
            }
            if(flg){
                System.out.println("Important!");
            }
            else{
                System.out.println("Ignore");
            }
        }
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/610e6c0387a0401fb96675f58cda8559
     * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
     * 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
     * 2. 待所有字条加入完毕，每人从箱中取一个字条；
     * 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
     * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
     *
     * 输入描述:
     * 输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
     *
     * 输出描述:
     * 对应每一组数据，以“xx.xx%”的格式输出发生无人获奖的概率。
     * 示例1
     * 输入
     * 2
     * 输出
     * 50.00%
     */
    //计算所有人都抽不到奖的情况：错排算法
    public static double count(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return (n-1)*(count(n-1)+count(n-2));
    }
    //计算阶乘：迭代写法
    public static double factorial(int n) {
        double sum = 1;
        while(n > 1){
            sum = sum*n;
            n--;
        }
        return sum;
    }
    //计算阶乘：递归写法
    public  static double factorical2(int n){
        if(n == 2) return 2;
        return n * factorical2(n-1);
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double sum1 = factorial(n);
            double sum2 = count(n);
            double result = (sum2/sum1) *100; //计算成%的形式
            System.out.println(String.format("%.2f", result)+"%");
        }
    }
}