import java.util.*;
public class Test21{
    // https://www.nowcoder.com/questionTerminal/eaf5b886bd6645dd9cfb5406f3753e15?orderByHotValue=1&commentTags=Java
    // MP3光标位置
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.next();
            int k = 1;
            int top = 1;//top是给正常情况（n>4）下准备的
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'U') {
                    if(top == k){
                        top = top-1;
                    }
                    k = k - 1;
                    if(k == 0){
                        k = n;
                        top = n-3;
                    }
                } else {
                    if(k == top+3){
                        top = top+1;
                    }
                    k = k + 1;
                    if(k > n){
                        k = 1;
                        top = 1;
                    }
                }
            }
            if(n < 4){
                for(int i = 1; i <= n; i++){
                    System.out.print(i+" ");
                }
            }
            else{
                for(int i = 0; i < 4; i++){
                    System.out.print(top++ +" ");
                }
            }
            System.out.println();
            System.out.println(k);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/5a0a2c7e431e4fbbbb1ff32ac6e8dfa0?toCommentId=9437283
     * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
     * 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。
     * 接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
     * 直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
     * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
     * 在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，
     * 我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
     * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
     * 输入描述:
     * 第一行一个数T(T ≤ 100)，表示数据组数。
     * 对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来有2n行个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
     * 输出描述:
     * 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
     * 示例1
     * 输入
     * 3
     * 3 1
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 3 2
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 2 2
     * 1
     * 1
     * 1
     * 1
     * 输出
     * 1 4 2 5 3 6
     * 1 5 4 3 2 6
     * 1 1 1 1
     */
    //优化后
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T != 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int tmp = 2*n;
            int[] array = new int[tmp];
            while(tmp != 0){
                array[2*n-tmp] = sc.nextInt();
                tmp--;
            }
            while(k != 0){
                int[] leftArray = new int[n];
                int[] rightArray = new int[n];
                for(int i = 0; i < n; i++){
                    leftArray[i] = array[i];
                    rightArray[i] = array[i+n];
                }
                int l = n-1;
                int r = n-1;
                int a = 2*n-1;
                while(a >= 0){
                    array[a--] = rightArray[r--];
                    array[a--] = leftArray[l--];
                }
                k--;
            }
            for(int i = 0; i < 2*n-1; i++){
                System.out.print(array[i]+" ");
            }
            System.out.println(array[2*n-1]);
            T--;
        }
    }
    // 优化前
    public static int[] shuffleCard(int[] array){
        int[] leftArray = new int[array.length/2];
        int[] rightArray = new int[array.length/2];
        for(int i = 0; i < array.length/2; i++){
            leftArray[i] = array[i];
            rightArray[i] = array[i+array.length/2];
        }
        int l = array.length/2-1;
        int r = array.length/2-1;
        int a = array.length-1;
        while(a >= 0){
            array[a--] = rightArray[r--];
            array[a--] = leftArray[l--];
        }
        return array;
    }
    public static void shuffleCardTimes(int[] array, int k){
        for(int i = 0; i < k; i++){
            shuffleCard(array);
        }
        for(int i = 0; i < array.length; i++){
            if(i == array.length-1){
                System.out.println(array[i]);
            }
            else{
                System.out.print(array[i] + " ");
            }
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T != 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int tmp = 2*n;
            int[] array = new int[2*n];
            while(tmp != 0){
                array[2*n-tmp] = sc.nextInt();
                tmp--;
            }
            shuffleCardTimes(array, k);
            T--;
        }
    }
}