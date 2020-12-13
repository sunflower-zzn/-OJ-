// 12.13
// 217 Contains Duplicate

/*
    给定一个整数数组，判断是否存在重复元素。
    如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

    输入: [1,2,3,1]
    输出: true

    输入: [1,2,3,4]
    输出: false

    输入: [1,1,1,3,3,4,3,2,4,2]
    输出: true
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution201213 {
    public boolean containsDuplicate(int[] nums) {
        //利用哈希表，复杂度O(N)
        /*
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
        */

        //利用数组排序判断重复元素,复杂度O(NlogN)
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return true;
        }
        return false;
    }
}
