import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/20 15:08
 * @Description 题目描述：
 * 小团现在有两个等大的多重集合（与集合的区别仅是在可以在集合中出现重复元素）A 和 B。她现在想让 A 集合与 B 集合相等。
 * 她会先选择一个非负整数 x，然后让 A 集合中的所有数都加上 x 并对 m 取模。也就是说，对于 A 中的全部元素 a，都把 a 变成 (a + x) mod m。
 * 她想知道这个最小的 x 是多少，才能使经过变换后 A = B。并且她保证至少存在一个满足条件的 x。
 *
 * 输入描述
 * 第一行两个正整数 n, m，n 表示 A, B 两集合分别有 n 个元素；
 * 第二行 n 个非负整数 ai，表示 A 多重集。
 * 第三行 n 个非负整数 bi，表示 B 多重集。
 * 1 ≤ n ≤ 2000, 1 ≤ m ≤ 109, 0 ≤ ai , bi < m。
 *
 * 输出描述
 * 输出一个非负整数，表示最小的 x 值。
 * 样例输入
 * 6 8
 * 1 1 4 5 1 4
 * 3 0 4 0 3 0
 * 样例输出
 * 7
 */
public class Q2 {
    public static class Main {
        public static void test() {
            //两个队列，队列a每次全体+1，直到a==b
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int amin = Integer.MAX_VALUE;
            int bmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                amin = Math.min(amin, num);
            }
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                bmin = Math.min(bmin, num);
            }
            int res = (bmin - amin + m) % m;
            System.out.println(res);
        }
    }

    public static void main(String args[]) {
        Main.test();
    }
}
