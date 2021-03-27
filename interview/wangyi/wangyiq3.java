import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 15:01
 * @Description 最大和问题——背包问题/DP
 */
public class wangyiq3 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n / 2; i++) {
                int tt = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = tt;
            }
            List<Integer> temp[] = new List[6];
            for (int i = 0; i < 6; i++) {
                temp[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int idx = arr[i] % 6;
                temp[idx].add(arr[i]);
            }
            int sum = 0;
            for (Integer num : temp[0]) {
                sum += num;
            }
            int len_1_5 = Math.min(temp[1].size(), temp[5].size());
            for (int i = 0; i < len_1_5; i++) {
                sum += temp[1].get(i);
                sum += temp[5].get(i);
            }
            int len_2_4 = Math.min(temp[2].size(), temp[4].size());
            for (int i = 0; i < len_2_4; i++) {
                sum += temp[2].get(i);
                sum += temp[4].get(i);
            }
            for (int i = 0; i < temp[3].size() - (temp[3].size() % 2); i++) {
                sum += temp[3].get(i);
            }
            if(sum==0)System.out.println(-1);
            else System.out.println(sum);
        }
    }

}
