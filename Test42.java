import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test42 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6276dbbda7094978b0e9ebb183ba37b9
     * 走迷宫-牛客
     * NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
     * 现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？
     * 输入描述:
     * 输入包含多组数据。
     * 每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
     * 入口在第一行第二列；出口在最后一行第九列。
     * 从任意一个“.”点都能一步走到上下左右四个方向的“.”点。
     *
     * 输出描述:
     * 对应每组数据，输出从入口到出口最短需要几步。
     * 示例1
     * 输入
     * #.########
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * #........#
     * ########.#

     * #.########
     * #........#
     * ########.#
     * #........#
     * #.########
     * #........#
     * ########.#
     * #........#
     * #.######.#
     * ########.#
     * 输出
     * 16
     * 30
     */
    // BFS广度优先搜索
    static int[][] direction1 = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[][] maze = new char[10][10];
            int[][] map = new int[10][10];
            boolean[][] visited = new boolean[10][10];
            for(int i = 0; i < 10; i++){
                String str = sc.next();
                for(int j = 0; j < 10; j++){
                    maze[i][j] = str.charAt(j);
                    if(maze[i][j] == '#'){
                        visited[i][j] = true;
                    }
                }
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 1));
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    Node next = new Node(cur.x+direction[i][0], cur.y+direction[i][1]);
                    if(next.x >= 0 && next.x < 10 && next.y >= 0 && next.y < 10
                            && !visited[next.x][next.y]){
                        queue.offer(next);
                        map[next.x][next.y] = map[cur.x][cur.y] + 1;
                        visited[next.x][next.y] = true;
                    }
                }
            }
            System.out.println(map[9][8]);
        }
    }
    // DFS深度优先搜索
    static int[][] direction = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    public static void dfs(int a, int b, char[][] maze, int[][] map){
        for(int i = 0; i < 4; i++){
            int x = a + direction[i][0];
            int y = b + direction[i][1];
            if(x >= 0 && x < 10 && y >= 0 && y < 10
                    && maze[x][y] == '.' && map[x][y] > map[a][b]+1){
                map[x][y] = map[a][b] + 1;
                dfs(x, y, maze, map);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[][] maze = new char[10][10];
            int[][] map = new int[10][10];
            for(int i = 0; i < 10; i++){
                String str = sc.next();
                for(int j = 0; j < 10; j++){
                    maze[i][j] = str.charAt(j);
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
            map[0][1] = 0;
            dfs(0, 1, maze, map);
            System.out.println(map[9][8]);
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/16fa68271ee5448cafd504bb4a64b482
     * 来源：牛客网
     * nowcoder要和朋友交流一些敏感的信息，例如他的电话号码等。
     * 因此他要对这些敏感信息进行混淆，比如在数字中间掺入一些额外的符号，让它看起来像一堆乱码。
     * 现在请你帮忙开发一款程序，解析从nowcoder那儿接收到的信息，读取出中间有用的信息。
     * 输入描述:
     * 输入有多行。
     * 每一行有一段经过加密的信息（其中可能包含空格），并且原始信息长度不确定。
     * 输出描述:
     * 输出每段信息中数字信息。
     * 示例1
     * 输入
     * $Ts!47&*s456  a23* +B9k
     * 输出
     * 47456239
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }
}