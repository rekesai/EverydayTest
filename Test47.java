import java.util.*;
class Node{
    int weight, height;
    public Node(int weight, int height){
        this.weight = weight;
        this.height = height;
    }
}
public class Test47 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/661c49118ca241909add3a11c96408c8
     * 来源：合唱团牛客网
     *
     * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
     * 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
     *
     * 输入描述:
     * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，
     * 表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
     * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
     *
     * 输出描述:
     * 输出一行表示最大的乘积。
     * 示例1
     * 输入
     * 3
     * 7 4 7
     * 2 50
     * 输出
     * 49
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            int K = sc.nextInt();
            int d = sc.nextInt();
            long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
            long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
            // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
            // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
            //初始化第一行
            long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
            for (int i = 1; i <=n; i++) {
                fmax[1][i] = arr[i];
                fmin[1][i] = arr[i];
                for (int k = 2; k <= K; k++) {
                    for (int j = i-1; j > 0 && i-j <= d; j--) {
                        fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                        fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                    }
                }
                res = Math.max(res ,fmax[K][i]);
            }
            System.out.println(res);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c2afcd7353f84690bb73aa6123548770
     * 来源：马戏团牛客网
     *
     * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，
     * 精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到，
     * 马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。
     * 考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。
     * 团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。
     * 小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，
     * 并且很快找到叠最高罗汉塔的人员序列。 现在你手上也拿到了这样一份身高体重表，
     * 请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。
     *
     * 输入描述:
     * 首先一个正整数N，表示人员个数。
     * 之后N行，每行三个数，分别对应马戏团员编号，体重和身高。
     *
     * 输出描述:
     * 正整数m，表示罗汉塔的高度。
     * 示例1
     * 输入
     * 6
     * 1 65 100
     * 2 75 80
     * 3 80 100
     * 4 60 95
     * 5 82 101
     * 6 81 70
     * 输出
     * 4
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            Node[] nums = new Node[n];
            for(int i = 0; i < n; i++){
                String[] tmp = sc.nextLine().split(" ");
                nums[i] = new Node(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            }
            Arrays.sort(nums, new Comparator<Node>(){
                public int compare(Node n1, Node n2){
                    int result = Integer.compare(n1.height, n2.height);
                    if(result != 0) return result;
                    return Integer.compare(n1.weight, n2.weight);
                }
            });
            int[] dp = new int[n];
            int max = 0;
            for(int i = 0; i < n; i++){
                dp[i] = 1;
                for(int j = i-1; j >= 0; j--){
                    if(nums[i].height == nums[j].height && nums[i].weight == nums[j].weight
                            || nums[i].weight > nums[j].weight){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}