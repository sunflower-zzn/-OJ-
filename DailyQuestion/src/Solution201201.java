// 12.01
// 34 Find First and Last Position of Element in Sorted Array

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。

    进阶：
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]

    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]

    输入：nums = [], target = 0
    输出：[-1,-1]
*/

public class Solution201201 {
    public int[] searchRange(int[] nums, int target) {
        /*
        //复杂度为n，双指针
        int head=-1,tail=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)tail=i;
            if(nums[nums.length-1-i]==target)head=nums.length-1-i;
        }
        return new int[]{head,tail};
        */

        //使用二分法，复杂度logn
        if(nums.length==0)return new int[]{-1,-1};
        int[] res=new int[2];
        res[0]=findhead(nums,0,nums.length-1,target);
        res[1]=findtail(nums,0,nums.length-1,target);
        return res;
    }

    private int findhead(int[] nums,int left,int right,int target){
        if(left==right){
            return nums[left]==target?left:-1;
        }
        int mid=(left+right)/2;
        int leftres=findhead(nums,left,mid,target);
        int rightres=findhead(nums,mid+1,right,target);
        if(leftres!=-1)return leftres;
        return rightres;
    }

    private int findtail(int[] nums,int left,int right,int target){
        if(left==right){
            return nums[left]==target?left:-1;
        }
        int mid=(left+right)/2;
        int leftres=findtail(nums,left,mid,target);
        int rightres=findtail(nums,mid+1,right,target);
        if(rightres!=-1)return rightres;
        return leftres;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        Solution201201 s =new Solution201201();
        s.searchRange(nums,8);
    }

}
