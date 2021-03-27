import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 19:24
 * @Description 二叉树u到v最短路径上所有节点的按位或的权值
 * 把所有的加起来
 * 并查集+位运算
 */
public class yuanq3 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                int ax[] = new int[N];
                for (int i = 0; i < N; i++) {
                    ax[i] = sc.nextInt();
                }
                int rel[][] = new int[N - 1][2];
                for (int i = 0; i < N - 1; i++) {
                    rel[i][0] = sc.nextInt();
                    rel[i][1] = sc.nextInt();
                }
                //todo
            }
        }
    }
}
