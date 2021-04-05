import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/30 18:59
 * @Description 数字跳跃
 * 0-9组成
 * 从第一个位置跳到最后一个位置
 * 每次可以选择向后跳一个或者跳到跟当前位置数字相同的任意一位
 */
public class baiduq1 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 1) {
                System.out.println(0);
                return;
            }
            if (n == 2) {
                System.out.println(1);
                return;
            }
            int nums[] = new int[n];
            //记录每个元素，及其下标(从前到后的链表)，只有0-9十个数
            List<Integer>[] map = new List[10];
            for (int i = 0; i < 10; i++) map[i] = new ArrayList<>();
            String ss[] = sc.nextLine().split("");
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(ss[i]);
                nums[i] = temp;
                map[temp].add(i);
            }
            int res=judge(0,0,nums,map);
            System.out.println(res);
        }

        public static int judge(int time, int index, int[] nums, List<Integer>[] map) {
            if (index == nums.length - 1) return time;
            List<Integer> templist = map[nums[index]];
            int lastIndex = templist.get(templist.size() - 1);
            if (index == lastIndex) {
                return judge(time + 1, index + 1, nums, map);
            } else {
                int time1 = judge(time + 1, index + 1, nums, map);
                int time2 = judge(time + 1, lastIndex, nums, map);
                return Math.min(time1, time2);
            }
        }


    }
}
