// 11.02
// 349 Intersection of Two Arrays

/*
    给定两个数组，编写一个函数来计算它们的交集

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。

*/

import java.util.HashSet;
import java.util.Set;

public class Solution201102 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                temp[index++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = temp[i];
        }
        return res;
    }
}
