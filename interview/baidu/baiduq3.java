import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/30 19:00
 * @Description 食堂就餐问题
 * 有n个学生和m个食堂
 * 每个食堂有ai个位置
 * 每个学生等概率地选择食堂
 * 在食堂内部学生会使ai个位置上队伍尽可能均等长
 * 求期望
 */
public class baiduq3 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ai[] = new int[m];
            for (int i = 0; i < m; i++) {
                ai[i] = sc.nextInt();
            }
            double res = 0.0;
            DecimalFormat df = new DecimalFormat();
            String style = "0.0000000000";
            df.applyPattern(style);
            System.out.println(df.format(res));
        }
    }
}
//Scanner sc = new Scanner(System.in);
//DecimalFormat df = new DecimalFormat();
//String style = "0.00";
//df.applyPattern(style);
//while (sc.hasNext()) {
//    int n = sc.nextInt();
//    String s = sc.nextLine();
//    System.out.println(s);
//    double num = 1234.5556;
//    System.out.println(df.format(num));
// 格式化之前的数字: 1234.56789
//采用style: 0.0格式化之后: 1234.6
//采用style: 00000.000 kg格式化之后: 01234.568 kg
//采用style: ##000.000 kg格式化之后: 1234.568 kg
//采用style: -000.000格式化之后: -1234.568
//采用style: -0,000.0#格式化之后: -1,234.57
//采用style: 0.00E000格式化之后: 1.23E003
//采用style: 0.00%格式化之后: 123456.79%
//采用style: 0.00‰格式化之后: 1234567.89‰
