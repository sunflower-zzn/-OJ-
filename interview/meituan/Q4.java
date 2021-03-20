import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/20 16:39
 * @Description 小美和小团的班上有 n 个人，分别编号为 1 到 n。其中小美的编号为 1，小团的编号为 2。
 * <p>
 * 班上有个值日表 ai,j。第一天由小美值日，第二天由小团值日。接下来的每一天，如果今天是 i 值日，昨天是 j 值日，那么明天就是 ai,j 值日。值日表是已经规划好的，保证今天值日的同学明天一定不值日。
 * 小美想知道，第 m 天值日的同学的编号。
 *
 * 输入描述
 * 第一行两个整数 n, m，表示班上有 n 个同学和小美想知道的天数。
 * 接下来 n 行，每行 n 个整数，表示值日表 ai,j (0 ≤ ai,j ≤ n)。保证有且仅有对角线上的数字是 0。
 * 1 ≤ n ≤ 500, 1 ≤ m ≤ 1018。
 * 输出描述
 * 输出一行一个整数，表示第 m 天值日的同学的编号。
 *
 * 样例输入
 * 3 7
 * 0 3 2
 * 3 0 3
 * 2 1 0
 * 样例输出
 * 1
 */
public class Q4 {
    public static class Main {
        public static void test() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();       //人数
            //考虑m是个Long类型！！
            int m = sc.nextInt();       //第几天
            int schedule[][] = new int[n][n];      //值班表
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    schedule[p][q] = sc.nextInt();
                }
            }
            //找规律！
            int row = 1, col = 0;
            List<Integer> list = new ArrayList<>();
            int i = 1;        //今天是i
            int j = 0;         //昨天是j
            while (true) {       //从第三天开始
                int temp = schedule[i][j];
                list.add(temp);
                j = i;
                i = temp - 1;
                if (i == row && j==col) break;
            }
            int idx=(m - 3) % list.size();
            int res = list.get(idx);
            System.out.println(res);
        }
    }

    public static void main(String args[]) {
        Main.test();
    }
}
