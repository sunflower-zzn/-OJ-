import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/20 15:08
 * @Description 学校正在举行喝奶茶比赛。这次比赛准备了 n 杯奶茶（为了比赛公平，奶茶里没有珍珠，椰果等各种小料，也就是纯奶茶），编号为 1 到 n。
 * 第 i 杯奶茶有 ai 毫升，这 n 杯奶茶准备的吸管都是一样的，每秒最多能吸上来 C 毫升奶茶，选手只能通过吸管吸奶茶，不能捅破包装把奶茶倒进嘴里，这样对其他选手不公平。
 * 选手按队伍参赛，小团所在的队伍有 m 个人，比赛要求队内的每个人选取编号在一个连续区间的奶茶喝，当然参赛选手也可以不喝任何奶茶。
 * 但是选定一杯奶茶喝就一定要喝完，不然的话这杯奶茶就被浪费了。
 * 如果小团所在队打破了校记录，那么她们队的每个人都将获得一年的奶茶畅饮卷，所以她想知道所有奶茶都被喝完的最短用时。
 *
 * 输入描述
 * 第一行三个整数 n, m, C，意义如题目描述。
 * 第二行 n 个整数，第 i 个整数为 ai。
 * 1 ≤ n, m ≤ 105, 1 ≤ C ≤ 50, 1 ≤ ai ≤ 104。
 * 输出描述
 * 输出一行一个整数，表示所有奶茶都被喝完的最短用时，为了保证精度，请输出答案上取整后的结果。
 * 样例输入
 * 5 3 4
 * 5 8 3 10 7
 * 样例输出
 * 4
 */
public class meituanq3 {
    public static class Main {
        public static void test() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();       //杯数
            int m = sc.nextInt();       //人数
            int c = sc.nextInt();         //每秒钟速度
            int milk[] = new int[n];      //每杯容量
            int sum = 0;                  //总容量
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                milk[i] = num;
                sum += num;
            }
            if (n <= m) {       //人数大于等于杯数，每人一杯，取决于最多的那杯
                int maxHeight = 0;
                for (int num : milk) {
                    maxHeight = Math.max(maxHeight, num);
                }
                System.out.println(maxHeight / c + 1);
            }
        }
    }

    public static void main(String args[]) {
        Main.test();
    }
}
