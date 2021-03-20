import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/20 15:08
 * @Description 输入描述
 * 第一行一个长为 26 的字符串 s，表示预先设置在设备中的小写英文字母排列。
 * <p>
 * 第二行一个长为 n 的字符串 a，表示小美想要生成的字符串。
 * <p>
 * 1 ≤ n ≤ 105，保证 s 一定是一个小写字母的排列，且 a 中只包含小写英文字母。
 * <p>
 * 输出描述
 * 输出一行一个整数，表示恰好生成完这个字符串时，浪费了这个流的多少个字符。
 * <p>
 * <p>
 * 样例输入
 * abcdefghijklmnopqrstuvwxyz
 * meituan
 * 样例输出
 * 59
 */
public class Q1 {
    public static class Main {
        public static void test() {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            s=s.substring(0,26);
            String a = sc.nextLine();
            char s_char[] = s.toCharArray();
            int n = s_char.length;
            char a_char[] = a.toCharArray();
            int sidx = 0;
            int aidx = 0;
            int res = 0;
            while (aidx < a.length()) {
                if (s_char[sidx] == a_char[aidx]) {
                    aidx++;
                }
                sidx = (sidx + 1) % n;
                res++;
            }
            System.out.println(res - a.length());
        }
    }

    public static void main(String args[]) {
        Main.test();
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
