import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/21 20:01
 * @Description
 */
public class tencentq2 {
    public static class Main {
        public static void test() {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                long n = sc.nextLong();
                //n=1+pow(2,p)*pow(3,q)+c
                int p = 0, q = 0;
                while (Math.pow(2, p) < n) p++;
                while (Math.pow(3, q) < n) q++;
                int res = (int) n;
                for (int a = 0; a < p; a++) {
                    for (int b = 0; b < q; b++) {
                        double num = Math.pow(2, a) * Math.pow(3, b);
                        if (num + 1 > n) break;
                        res = (int) Math.min(res, 1 + a + b + (n - num));
                    }
                }
                System.out.println(res);
            }
        }

        public static void main(String[] args) {
            test();
        }
    }
}
