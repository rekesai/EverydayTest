import java.util.*;
public class Test45 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/03ba8aeeef73400ca7a37a5f3370fe68
     * 查找兄弟单词牛客网
     *
     * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
     * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
     * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，按字典序排列后的第k个单词是什么？
     * 注意：字典中可能有重复单词。本题含有多组输入数据。
     *
     * 输入描述:
     * 先输入单词的个数n，再输入n个单词。
     * 再输入一个单词，为待查找的单词x
     * 最后输入数字k
     *
     * 输出描述:
     * 输出查找到x的兄弟单词的个数m
     * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
     * 示例1
     * 输入
     * 3 abc bca cab abc 1
     * 输出
     * 2
     * bca
     * 示例2
     * 输入
     * 6 cab ad abcd cba abc bca abc 1
     * 输出
     * 3
     * bca
     * 说明
     * abc的兄弟单词有cab cba bca，所以输出3
     * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
     */
    public static boolean check(String s1, String s2){
        if(s1.length() != s2.length() || s1.equals(s2)) return false;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++){
            list1.add(s1.charAt(i));
            list2.add(s2.charAt(i));
        }
        for(int i = 0; i < list1.size(); i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
            }
            else{
                return false;
            }
        }
        if(!list2.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(check(str[i+1], str[n+1])) list.add(str[i+1]);
            }
            int k = Integer.parseInt(str[str.length-1]);
            Collections.sort(list);
            System.out.println(list.size());
            if(k-1 < list.size()){
                System.out.println(list.get(k-1));
            }
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32?pos=100&orderByHotValue=1
     * 乒乓球筐牛客
     * nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的。。。。。。现在他需要判别A盒是否包含了B盒中所有的种类，
     * 并且每种球的数量不少于B盒中的数量，该怎么办呢？
     *
     * 输入描述:
     * 输入有多组数据。
     * 每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
     * 字符串长度不大于10000。
     *
     * 输出描述:
     * 每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
     * 示例1
     * 输入
     * ABCDFYE CDE
     * ABCDGEAS CDECDE
     * 输出
     * Yes
     * No
     *
     */
    public static boolean fun(String s1, String s2){
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            if(!mapA.containsKey(s1.charAt(i))){
                mapA.put(s1.charAt(i), 1);
            }
            else{
                int a = mapA.get(s1.charAt(i));
                mapA.put(s1.charAt(i), a+1);
            }
        }
        for(int i = 0; i < s2.length(); i++){
            if(!mapB.containsKey(s2.charAt(i))){
                mapB.put(s2.charAt(i), 1);
            }
            else{
                int b = mapB.get(s2.charAt(i));
                mapB.put(s2.charAt(i), b+1);
            }
        }
        for(Map.Entry<Character, Integer> entry : mapB.entrySet()){
            if(mapA.containsKey(entry.getKey())){
                if(entry.getValue() > mapA.get(entry.getKey())){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            if(fun(str[0], str[1])){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            ArrayList<Character> listA = new ArrayList<>();
            ArrayList<Character> listB = new ArrayList<>();
            for(int i = 0; i < str[0].length(); i++){
                listA.add(str[0].charAt(i));
            }
            for(int i = 0; i < str[1].length(); i++){
                listB.add(str[1].charAt(i));
            }
            for(int i = 0; i < listA.size(); i++){
                if(listB.contains(listA.get(i))){
                    listB.remove(listA.get(i));
                }
            }
            if(listB.isEmpty()){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}