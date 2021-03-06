// 12.02
// 321 Create Maximum Number

/*
   给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
    求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
    说明: 请尽可能地优化你算法的时间和空间复杂度。

    输入:
    nums1 = [3, 4, 6, 5]
    nums2 = [9, 1, 2, 5, 8, 3]
    k = 5
    输出:
    [9, 8, 6, 5, 3]

    输入:
    nums1 = [6, 7]
    nums2 = [6, 0, 4]
    k = 5
    输出:
    [6, 7, 6, 0, 4]

    输入:
    nums1 = [3, 9]
    nums2 = [8, 9]
    k = 3
    输出:
    [9, 8, 9]
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201202 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //采取分治算法，先从两个数组中取x1，x2长度的数组，然后把两个数组拼起来最大即可
        int resultSum = 0;
        List<Integer> result = new ArrayList<>();
        List<Integer> list1, list2;
        //遍历去除长度和为k的两段数组
        for (int i = 0; i <= k; i++) {
            if (nums1.length >= i) {
                list1 = findMaxSubArrays(nums1, i);
                list2 = findMaxSubArrays(nums2, k - i);
            }
        }
        return null;
    }

    public List<Integer> findMaxSubArrays(int[] nums, int length) {
        //从数组中取出最大的length个数字，并保持顺序
        if (length == 0) return new ArrayList<>();
        //转化成题402：去掉k位数字,使剩下的数字组成最大
        List<Integer> numlist = new ArrayList<>();
        for (int num : nums) numlist.add(num);
        int k = nums.length - length;
        while (k > 0) {
            int index = 0;
            for (int i = 0; i < numlist.size() - 1; i++) {
                if (numlist.get(i) < numlist.get(i)) break;
                index = i;
            }
            numlist.remove(index);
            k--;
        }
        return numlist;
    }

    public int listSum(List<Integer> nums) {
        //返回List构成的数字大小
        int res = 0;
        for (int num : nums) {
            res += num;
            res *= 10;
        }
        return res / 10;
    }

    public List<Integer> joinList(List<Integer> list1, List<Integer> list2) {
        //拼接两个list，保证组合成的数字和最大，且保持相对顺序
        return null;
    }
}
