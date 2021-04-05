import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/31 18:48
 * @Description 一个数组，每个数表示反馈跟自己帽子颜色相同的人的个数
 * 返回最少需要多少个帽子（也就是最少需要多少个人参与）
 * 有的人可能不给反馈！
 * input：[1, 1, 2]
 * output：5
 * 第一个和第二个相同，那么需要额外的两个人与第三个相同
 * <p>
 * input：[]
 * output：0
 * 没有人反馈
 */
public class huaweiq2 {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
            if (temp.length() <= 2) {
                System.out.print(0);
                return;
            }
            String shats[] = temp.substring(1, temp.length() - 1).split(",");
            //靠！测试用例和后台用例不一样！！！
            int hats[] = new int[shats.length];
            for (int i = 0; i < hats.length; i++) {
                if(shats[i].equals(" "))continue;
                hats[i] = Integer.parseInt(shats[i]);
            }
            Arrays.sort(hats);
            //hats[i]==num，意味着需要num+1个hat[i]才能满足，这里就多出了额外的人数
            int info[] = new int[1000];
            for (int num : hats) {
                info[num]++;
            }
            int res = hats.length;
            for (int i = 1; i < 1000; i++) {
                int needmore = info[i] % (i + 1);
                if (needmore != 0) {
                    res += i + 1 - needmore;
                }
            }
            System.out.println(res);
        }
    }
}
