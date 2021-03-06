// 2.7
// 665. Non-decreasing Array(非递减数列)

/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 
说明：
1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
*/

import java.util.ArrayList;
import java.util.List;

public class Solution210207 {
    public boolean checkPossibility(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])list.add(i);
        }
        if(list.isEmpty())return true;
        if(list.size()>1)return false;
        int index=list.get(0);
        if(index==0 || index==nums.length-2)return true;
        if(nums[index-1]<=nums[index+1] || nums[index]<=nums[index+2])return true;
        return false;
    }
}
