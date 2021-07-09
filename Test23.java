import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test23 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/3959837097c7413a961a135d7104c314?commentTags=Java
     * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
     * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
     * 编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
     * Ex：
     * 字符串A:abcdefg
     * 字符串B: abcdef
     * 通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
     * 要求：
     * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
     * 本题含有多组输入数据。
     * 输入描述:
     * 每组用例一共2行，为输入的两个字符串
     * 输出描述:
     * 每组用例输出一行，代表字符串的距离
     * 示例1
     * 输入
     * abcdefg
     * abcdef
     * abcde
     * abcdf
     * abcde
     * bcdef
     * 输出
     * 1
     * 1
     * 2
     * java解法
     * DP:
     * (1)k1代表替换：
     * 相等 k1 = arr[i-1][i1-1]
     * 不相等 k1 = arr[i-1][i1-1]+1
     * (2)k2代表删除str1中的这个字符：
     * k2 = arr[i-1][i1] + 1
     * (3)k3代表增加str2的这个字符到str1中：
     * k3 = arr[i][i1-1] + 1
     * (4)arr[i][i1-1]取k1,k2,k3的最小值
     * (5)要先把当i=0或者i1=0时，arr[i][i1]的值先填上
     */
    public static void main(String[] args) {
        Scanner scnner = new Scanner(System.in);
        while(scnner.hasNext()){
            String str1 = scnner.nextLine();
            String str2 = scnner.nextLine();
            int l1 = str1.length();
            int l2 = str2.length();
            str1 = " "+ str1;
            str2 = " "+ str2;
            int[][] arr = new int[l1+1][l2+1]; //记录最长子字符串
            //str1为空时，转换需要的次数
            for (int i = 1; i <= l2; i++) {
                arr[0][i] = i;
            }
            //str2为空时，转换需要的次数
            for (int i = 1; i <= l1; i++) {
                arr[i][0] = i;
            }
            for (int i = 1; i <= l1; i++) {
                for (int i1 = 1; i1 <= l2; i1++) {
                    int k1;
                    if(str1.charAt(i) == str2.charAt(i1)){
                        k1 = arr[i-1][i1-1];
                    }else{
                        k1 = arr[i-1][i1-1] + 1;
                    }
                    int k2 = arr[i-1][i1] + 1; //删除str1[i]
                    int k3 = arr[i][i1-1] + 1; //增加str2[i1]
                    arr[i][i1] = Math.min(k1,k2);
                    arr[i][i1] = Math.min(arr[i][i1],k3);
                }
            }
            System.out.println(arr[l1][l2]);
        }
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fbcf95ed620f42a88be24eb2cd57ec54
     * 春节期间小明使用微信收到很多个红包，非常开心。
     * 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
     * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
     * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
     * 若没有金额超过总数的一半，返回0。
     * 测试样例：
     * [1,2,3,2,2],5
     * 返回：2
     */
    public int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(gifts[i])){
                map.put(gifts[i], 1);
            }
            else{
                int tmp = map.get(gifts[i]);
                map.put(gifts[i], tmp+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() >= n/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
