import java.util.*;
public class Test15{

    /**
     *链接：https://www.nowcoder.com/questionTerminal/365d5722fff640a0b6684391153e58d8?orderByHotValue=0&commentTags=C/C++
     * 来源：牛客网
     * 在地下室里放着n种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数不一定相同。
     * A先生现在要出门，所以他要去地下室选手套。但是昏暗的灯光让他无法分辨手套的颜色，只能分辨出左右手。
     * 所以他会多拿一些手套，然后选出一双颜色相同的左右手手套。
     * 现在的问题是，他至少要拿多少只手套(左手加右手)，才能保证一定能选出一双颜色相同的手套。
     * 给定颜色种数n(1≤n≤13),同时给定两个长度为n的数组left,right,分别代表每种颜色左右手手套的数量。
     * 数据保证左右的手套总数均不超过26，且一定存在至少一种合法方案。
     *
     * 测试样例：
     * 4,[0,7,1,6],[1,5,0,6]  //4种颜色，左手套对应的颜色有[0,7,1,6]个，右手套对应的颜色有[1,5,0,6]个
     * 返回：10(解释：可以左手手套取2只，右手手套取8只)
     *
     * 必须把对面有0的加起来，将 自己不是0，对面也不是0的放进一个表里，得出两个数组之间 表里总和减表中最小值+1 的最小值 再加1
     * 这个值就是结果
     */
    public int findMinimum(int n, int[] left, int[] right) {
        int min = 0;
        int sumL = 0;
        int sumR = 0;
        ArrayList<Integer> listL = new ArrayList<>();
        ArrayList<Integer> listR = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(right[i] != 0){
                sumL += left[i];
            }
            else{
                min += left[i];
            }
            if(left[i] != 0){
                sumR += right[i];
            }
            else{
                min += right[i];
            }
            if(left[i] != 0 && right[i] != 0){
                listL.add(left[i]);
                listR.add(right[i]);
            }
        }
        sumL -= Collections.min(listL);
        sumR -= Collections.min(listR);
        return sumL < sumR ? min+sumL+2 : min+sumR+2;
    }


    public static void main(String[] args) {
        double a = 3.14;
        int b = 2;
        System.out.println(a+b);
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1b46eb4cf3fa49b9965ac3c2c1caf5ad?commentTags=Python
     * 输入一个正整数，计算它在二进制下的1的个数。
     * 注意多组输入输出！！！！！！
     * 输入描述:
     * 输入一个整数
     * 输出描述:
     * 计算整数二进制中1的个数
     * 示例1
     * 输入
     * 5
     * 输出
     * 2
     * 说明
     * 5的二进制表示是101，有2个1
     */
    public static int findNumberOf1(int num){
        int count = 0;
        boolean flag = true;
        if(num < 0){
            num = -num;
            flag = false;
        }
        while(num != 0){
            if((num&1) == 1){
                count++;
            }
            num = num >>> 1;
        }
        if(!flag){
            count += 1;
        }
        return count;
    }
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int num = s. nextInt();
            int ret = findNumberOf1(num);
            System.out.println(ret);
        }
    }
}