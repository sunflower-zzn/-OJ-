import java.util.HashMap;
import java.util.Map;

/**
 * @Author sunflower_zzn
 * @Date 2021/4/19 11:49
 * @Description 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * 提示：
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class Solution210417 {
/*    //红黑树有序序列，支持范围查找和快速插入删除节点
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];
            Long left = tree.floor(num);      //小于等于num的最大值
            Long right = tree.ceiling(num);   //大于等于num的最小值
            if (left != null && num - left <= t) return true;
            if (right != null && right - num <= t) return true;
            tree.add(num);
            if (i >= k) tree.remove((long) nums[i - k]);    //维持 [max(0, i - k), i)，保证窗口长度为k
        }
        return false;
    }*/


    //桶排序，对于一个数num，将其[num-t,num+t]范围内的数都放在一个桶内，查询就是O(1)的了
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //对于每一个数num，计算其应该处在的桶的idx
        //      正数：idx = num/(t+1)
        //      负数：idx = (num+1)/t+1 - 1
        //每次检查是否存在idx的桶，如果存在直接返回true
        //然后检查idx-1和idx+1的桶中是否存在[num-t,num+t]
        //否则建立新桶idx
        Map<Long, Long> map = new HashMap<>();
        int size = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long idx = getIdx(num, size);
            if (map.containsKey(idx)) return true;
            if (map.containsKey(idx - 1) && num - map.get(idx - 1) <= t) return true;
            if (map.containsKey(idx + 1) && map.get(idx + 1) - num <= t) return true;
            map.put(idx, num);
            if (i >= k) map.remove(getIdx(nums[i - k], size));  //如果由相同idx桶的数字就已经返回了！所以不会多删除
        }
        return false;
    }

    private long getIdx(long num, int size) {
        return (long) num >= 0 ? num / size : (num + 1) / size - 1;
    }

}
