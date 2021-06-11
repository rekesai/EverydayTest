import java.math.BigInteger;
import java.util.Scanner;
public class Test17{


    // 输入两个超长的正整数，使其相加，正常的整数相加肯定不行，用BigInteger可以做到超大数字的相加
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String addend = s.nextLine();
            String augend = s.nextLine();
            BigInteger b1 = new BigInteger(addend);
            BigInteger b2 = new BigInteger(augend);
            // 这个可以让他输出的是字符串类型 + " "
            System.out.println(b1.add(b2) + "");
        }
    }

    /**
     *描述
     * 1
     * 1  1  1
     * 1  2  3  2  1
     * 1  3  6  7  6  3  1
     * 1  4  10 16 19 16 10 4 1
     * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
     * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
     * 输入n(n <= 1000000000)
     * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
     * 输入描述：
     * 输入一个int整数
     * 输出描述：
     * 输出返回的int值
     * 示例1
     * 输入：
     * 4
     * 2
     * 复制
     * 输出：
     * 3
     * -1
     */
    public static int yangHuiTriangle(long[][] nums, int n){
        // 先给第一行第一个赋值
        nums[0][0] = 1;
        // 从第二行开始遍历
        for(int i = 1; i < n; i++){
            // 第一行是一个，第二行是三个，第三行是五个，所以 j < 2*(i+1)-1
            for(int j = 0; j < 2*(i+1)-1; j++){
                int k = 0;
                long sum = 0;
                // 杨辉三角变形，头上的和头上左右的三个值的和，当在数组中就是头上的和头上的前两个 三个值的和
                // 要保证头上前两个和前一个有值，不要数组越界
                // 在创建数组时给最后一行以上的行都留了很大空间，没填值就是0，加了也无妨
                while(j-k >= 0 && k < 3){
                    sum += nums[i-1][j-k];
                    k++;
                }
                nums[i][j] = sum;
                // 给杨辉三角中赋值的同时，当走到第 n 行的时候，且当前填进去的这个数字是一个偶数，返回他的j下标+1
                if(i == n-1 && nums[i][j]%2 == 0){
                    return j+1;
                }
            }
        }
        // 遍历完成还没返回偶数的下标，证明没找到，返回-1
        return -1;
    }
    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            // 加起来的数字可能很大，所以用long
            long[][] nums = new long[n][n*2-1];
            System.out.println(yangHuiTriangle(nums, n));
        }
    }
}