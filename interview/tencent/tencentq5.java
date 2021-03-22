import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/21 19:59
 * @Description
 */
public class tencentq5 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int items[] = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int item = sc.nextInt();
                    sum += item;
                    items[i] = item;
                }
                if (sum % m == 0) {
                    //正好整倍数
                    System.out.println(0);
                } else {
                    Arrays.sort(items);
                    int res = 0;
                    //记录所有两两能凑成m的倍数的元素个数
                    List<Integer>[] mods = new List[m];
                    for(int i=0;i<m;i++){
                        mods[i]=new ArrayList<>();
                    }
                    for (int item : items) {
                        mods[item % m].add(item);
                    }
                    for (int i = 1; i <= m / 2; i++) {
                        int diff = mods[i].size() - mods[m - i].size();
                        if (diff < 0) {
                            for (int k = 0; k < -diff; k++) {
                                res += mods[m - i].get(k);
                            }
                        } else if (diff > 0) {
                            for (int k = 0; k < diff; k++) {
                                res += mods[i].get(k);
                            }
                        }
                    }
                    //处理中间，对于偶数个
                    if (m % 2 == 0) {
                        if (mods[m / 2].size() % 2 == 1) {
                            res += mods[m / 2].get(0);
                        }
                    }
                    System.out.println(res);
                }
            }
        }
    }
}
