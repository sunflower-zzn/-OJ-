import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 15:00
 * @Description 二叉树中的最优质路径
 * 宽度优先遍历的二叉树
 * 如何把广度优先变成深度优先？
 */
public class wangyiq1 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //读取二叉树
            String line = sc.nextLine();
            if (line.length() <= 3) {
                System.out.println("[]");
                return;
            }
            String trees[] = line.substring(1, line.length() - 1).split(",");
            int arr[] = new int[trees.length];
            for (int i = 0; i < trees.length; i++) {
                if (trees[i].equals("null")) arr[i] = 0;
                else arr[i] = Integer.parseInt(trees[i]);
            }
            //读取k
            int k = sc.nextInt();
            //把宽度优先变为深度优先遍历即可！
            //深度优先遍历，回溯算法
            List<List<Integer>> res = new ArrayList<>();
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            int arr_idx = 1;
            while (true) {
                list.add(arr[arr_idx - 1]);
                sum += arr[arr_idx - 1];
                if (sum < k && arr_idx * 2 < arr.length) {  //继续深入
                    arr_idx = arr_idx * 2;
                } else {
                    if (sum == k) { //等于的情况下记录结果
                        res.add(new ArrayList<>(list));
                    }
                    sum -= arr[arr_idx - 1];
                    list.remove(list.size() - 1);
                    if (arr_idx % 2 == 0) {
                        arr_idx++;
                    } else {
                        if (arr_idx == arr.length) break;
                        while ((arr_idx / 2) % 2 != 0) {
                            arr_idx = arr_idx / 2;
                            sum -= arr[arr_idx - 1];
                            list.remove(list.size() - 1);
                        }
                        if (list.isEmpty()) break;
                        sum -= arr[(arr_idx / 2) - 1];
                        list.remove(list.size() - 1);
                        arr_idx = arr_idx / 2 + 1;
                    }
                }
            }
            int res_len = Integer.MAX_VALUE;
            int res_idx = 0;
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).size() < res_len) {
                    res_idx = i;
                    res_len = res.get(i).size();
                }
            }
            System.out.print("[");
            for (int i = 0; i < res_len; i++) {
                System.out.print(res.get(res_idx).get(i));
                if (i < res_len - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
