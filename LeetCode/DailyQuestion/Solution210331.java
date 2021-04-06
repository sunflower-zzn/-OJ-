import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/31 12:41
 * @Description 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Solution210331 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    //迭代遍历子集,时间复杂度O(n x 2^n)，空间复杂度O(n)
    //剪枝：如果cur跟pre相同，而且pre没有被选，那么选cur的子集一定已经出现过了！
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //对数组排序，保证重复的子集内部顺序一致
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) { //mask:0~2^n，这么多种可能
            list.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {   //从每一种可能中选择数字加入list和结果集
                if ((mask & (1 << i)) != 0) {   //如果要选当前这个数
                    if (i > 0 && (mask & (1 << i - 1)) == 0 && nums[i] == nums[i - 1]) {
                        //前一个数对应的mask没有被选，所以当前子集肯定出现过了，排除
                        flag = false;
                        break;
                    }
                    list.add(nums[i]);
                }
            }
            if (flag) {
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }


/*    //递归方法，时间复杂度O(n x 2^n)，空间复杂度O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //对数组排序，保证重复的子集内部顺序一致
        Arrays.sort(nums);
        subset(nums, 0);
        return res;
    }

    public void subset(int[] nums, int idx) {
        if (idx == nums.length) {
            //利用list的contain方法判断是否重复
            List<Integer> temp = new ArrayList<>(list);
            if (!res.contains(temp)) res.add(temp);
        } else {
            subset(nums, idx + 1);
            list.add(nums[idx]);
            subset(nums, idx + 1);
            list.remove(list.size() - 1);
        }
    }*/

}
