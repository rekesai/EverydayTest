import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test38 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/ed9bc679ea1248f9a3d86d0a55c0be10
     * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。
     * 现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线
     * 在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格)
     * 问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
     *
     * 输入描述:
     * 第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
     * 输出描述:
     * 输出一行，代表所求概率(保留到2位小数)
     * 示例1
     * 输入
     * 2 2 1
     * 2 1
     * 输出
     * 0.50
     */
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int n = sca.nextInt();
            int m = sca.nextInt();
            int k = sca.nextInt();
            boolean[][] map = new boolean[n][m];
            for(int i = 0; i < k; i++) {
                int x = sca.nextInt()-1;
                int y = sca.nextInt()-1;
                map[x][y] = true;
            }
            double[][] cw = new double[n][m];
            cw[0][0] = 1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j]){
                        cw[i][j] = 0;
                    }
                    else if(i != 0 || j != 0){
                        cw[i][j] = (j-1 < 0 ? 0 : (i+1 < n ? cw[i][j-1]*0.5 : cw[i][j-1]))
                                +(i-1 < 0 ? 0 : (j+1 < m ? cw[i-1][j]*0.5 : cw[i-1][j]));
                    }
                    //System.out.print(String.format("%.5f",cw[i][j])+" ");
                }
                //System.out.println();
            }
            double res = cw[n-1][m-1];
            System.out.println(String.format("%.2f", res));
        }
    }
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/5017fd2fc5c84f78bbaed4777996213a?pos=13&mutiTagIds=584&orderByHotValue=0&questionTypes=000100
     * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。
     * 你站在其中一块黑色的瓷砖上，只能向相邻的（上下左右四个方向）黑色瓷砖移动。
     * 请写一个程序，计算你总共能够到达多少块黑色的瓷砖。
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据第一行是两个整数 m 和 n（1≤m, n≤20）。紧接着 m 行，每行包括 n 个字符。每个字符表示一块瓷砖的颜色，规则如下：
     * 1. “.”：黑色的瓷砖；
     * 2. “#”：白色的瓷砖；
     * 3. “@”：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。
     *
     * 输出描述:
     * 对应每组数据，输出总共能够到达多少块黑色的瓷砖。
     * 示例1
     * 输入
     * 9 6
     * ....#.
     * .....#
     * ......
     * ......
     * ......
     * ......
     * ......
     * #@...#
     * .#..#.
     * 输出
     * 45
     */
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
         this.x = x;
         this.y = y;
        }
    }
    public static void bfs(char[][] map, int[][] direction, Node start) {
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.add(start);
        visited[start.x][start.y] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int i = 0; i < 4; i ++ ) {
                Node next = new Node(cur.x + direction[i][0], cur.y + direction[i][1]);
                if(next.x >= 0 && next.x < map.length && next.y >= 0 && next.y < map[0].length
                        && map[next.x][next.y] != '#' &&  !visited[next.x][next.y]) {
                    count ++;
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[m][n];
            Node start = null;
            for(int i = 0; i < m; i ++) {
                String s = sc.nextLine();
                for (int j = 0; j < n; j ++ ) {
                    map[i][j] = s.charAt(j);
                    if(s.charAt(j) == '@') {
                        start = new Node(i, j);
                    }
                }
            }
            int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            bfs(map, direction, start);
        }
    }
}