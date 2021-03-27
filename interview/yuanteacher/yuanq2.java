import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 19:23
 * @Description n个数做或操作后小于目标数
 */
public class yuanq2 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            long res = 0;
            //首先处理所有比target大的数
            int pre = 0;
            int idx = 0;
            while (idx < len) {
                //找到比它大的，范围是【pre，idx-1】
                while (idx < len && arr[idx] <= target) {
                    idx++;
                }
                for (int i = pre; i < idx; i++) {
                    //int temp = 0;
                    for (int j = i; j < idx; j++) {
                        /*temp = temp | arr[j];
                        if (temp < target) res++;
                        else break;*/
                        res++;
                    }
                }
                idx++;
                pre = idx;
            }
            res = res % (1000000007);
            System.out.println(res);
        }
    }
}
