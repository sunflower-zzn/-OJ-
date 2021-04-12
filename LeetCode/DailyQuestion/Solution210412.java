import java.util.Arrays;

/**
 * @Author sunflower_zzn
 * @Date 2021/4/12 13:16
 * @Description 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class Solution210412 {
    public String largestNumber(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) res[i] = nums[i];
        Arrays.sort(res, (o1, o2) -> {
            String str1 = o1.toString();
            String str2 = o2.toString();
            return (str2 + str1).compareTo(str1 + str2);
        });
        if (res[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num);
        }
        return sb.toString();
    }
}
