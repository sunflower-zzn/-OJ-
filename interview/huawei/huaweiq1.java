import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/31 18:48
 * @Description 球队比赛积分
 * 积分按照降序和球队字典序输出
 */
public class huaweiq1 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int res[][] = new int[26][2];
            for (int i = 0; i < 26; i++) {
                res[i][0] = -1;
                res[i][1] = i;
            }
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                int team1 = temp.charAt(0) - 'a';
                if (res[team1][0] == -1) res[team1][0] = 0;
                int team2 = temp.charAt(2) - 'a';
                if (res[team2][0] == -1) res[team2][0] = 0;
                int score1 = temp.charAt(4) - '0';
                int score2 = temp.charAt(6) - '0';
                if (score1 > score2) res[team1][0] += 3;
                else if (score1 < score2) res[team2][0] += 3;
                else {
                    res[team1][0] += 1;
                    res[team2][0] += 1;
                }
            }
            Arrays.sort(res, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o2[0] - o1[0];
                    }
                }
            });
            int len = 0;
            for (int i = 0; i < 26; i++) {
                if (res[i][0] > -1) len++;
            }
            for (int i = 0; i < len; i++) {
                System.out.print((char) (res[i][1] + 'a'));
                System.out.print(" ");
                System.out.print(res[i][0]);
                if (i < len - 1) System.out.print(",");
            }
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