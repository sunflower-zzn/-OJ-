import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/31 18:48
 * @Description 
 */
public class huaweiq3 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[] arrs = sc.nextLine().toCharArray();
            char[] target = sc.nextLine().toCharArray();
            int index = sc.nextInt();
            List<Integer> list[] = new List[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < arrs.length; i++) {
                list[arrs[i] - 'a'].add(i);
            }
            int res = 0;
            int tar = 0;
            while (tar < target.length) {
                char ch = target[tar];
                if (arrs[index] == ch) {
                    tar++;
                } else {
                    int temp = Integer.MAX_VALUE;
                    int nextindex = index;
                    List<Integer> templist = list[ch - 'a'];
                    for (int num : templist) {
                        int dist = Math.min(Math.abs(index - num), arrs.length - Math.abs(index - num));
                        temp = Math.min(temp, dist);
                        if (temp == dist) nextindex = num;
                    }
                    res += temp;
                    index = nextindex;
                    tar++;
                }
            }
            System.out.println(res);
        }
    }
}
