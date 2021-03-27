import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 19:23
 * @Description 一个数组中只包含两个非递增数组，并且能接上！
 * 3
 * 3 1 4 3
 * 4 2 5 3 1
 * 4 13 9 5 5
 * Y
 * N
 * Y
 */
public class yuanq1 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int nn = 0; nn < n; nn++) {
                int k = sc.nextInt();
                int arr[] = new int[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = sc.nextInt();
                }
                int min1 = Integer.MAX_VALUE;
                int max1 = arr[0];
                int min2 = Integer.MAX_VALUE;
                int max2 = Integer.MIN_VALUE;
                boolean isbeen = false;
                boolean res = true;
                int idx = 0;
                while (idx < k - 1) {
                    if (arr[idx] < arr[idx + 1]) {
                        if (isbeen) {
                            res = false;
                            break;
                        }
                        min1 = arr[idx];
                        max2 = arr[idx + 1];
                        isbeen = true;
                    }
                    idx++;
                }
                min2 = arr[idx];
                if (res) {
                    if (isbeen) {
                        if (max1 <= min2 || max2 <= min1) System.out.println("Y");
                        else System.out.println("N");
                    } else System.out.println("Y");
                } else System.out.println("N");
            }
        }
    }
}
