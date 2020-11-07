// 10.26
// 1365 How Many Numbers Are Smaller Than the Current Number

/*
    给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    以数组形式返回答案。

    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Explanation:
    For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
    For nums[1]=1 does not exist any smaller number than it.
    For nums[2]=2 there exist one smaller number than it (1).
    For nums[3]=2 there exist one smaller number than it (1).
    For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

    Input: nums = [6,5,4,8]
    Output: [2,1,0,3]

    Input: nums = [7,7,7,7]
    Output: [0,0,0,0]

    2 <= nums.length <= 500
    0 <= nums[i] <= 100
*/


public class Solution201026 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /*
        //暴力解法，O(n^2)
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]&&i!=j){
                    res[i]++;
                }
            }
        }
        return res;
        */

        //找到最大值，然后统计0-max出现的每个数的个数
        int maxnum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxnum)maxnum=nums[i];
        }
        int ans[]=new int[maxnum+1];
        for(int i=0;i<nums.length;i++){
            ans[nums[i]]++;
        }
        for(int i=1;i<maxnum+1;i++){
            ans[i]+=ans[i-1];
        }
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)res[i]=0;
            else res[i]=ans[nums[i]-1];
        }
        return res;

    }

    public static void main(String[] args) {
        int nums[]={8,1,2,2,5};
        Solution201026 s=new Solution201026();
        s.smallerNumbersThanCurrent(nums);
    }
}
