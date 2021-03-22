import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/21 19:59
 * @Description
 */
public class tencentq3 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //接受数组
            int n = sc.nextInt();
            String[] str_arrs = new String[n];
            for (int i = 0; i < n; i++) {
                sc.nextInt();
                str_arrs[i] = sc.nextLine();
            }
            //处理string->arr
            List<List<Integer>> arrs = new ArrayList<>();
            for (String s : str_arrs) {
                arrs.add(str2list(s));
            }
            //接受查询
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int p = sc.nextInt(); //要合并的数组个数
                int combine[] = new int[p];
                for (int j = 0; j < p; j++) {
                    combine[j] = sc.nextInt() - 1;
                }
                int idx = sc.nextInt() - 1;     //要查询的升序数组idx
                System.out.println(search(arrs,combine,idx));
            }
        }

        public static List<Integer> str2list(String s) {
            List<Integer> res = new ArrayList<>();
            String s_arr[] = s.split(" ");
            for (String t : s_arr) {
                if(t.equals(""))continue;
                res.add(Integer.valueOf(t));
            }
            return res;
        }

        public static int search(List<List<Integer>> arrs, int[] combine, int idx) {
            List<Integer> combineArr = new ArrayList<>();
            for (int arr_idx : combine) {
                List<Integer> arr = arrs.get(arr_idx);
                combineArr.addAll(arr);
                combineArr.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
            }
            return combineArr.get(idx);
        }
    }
}
