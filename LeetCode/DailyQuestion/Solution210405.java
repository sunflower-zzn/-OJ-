/**
 * @Author sunflower_zzn
 * @Date 2021/4/5 15:44
 * @Description 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Solution210405 {
/*    //法一：直接合并后排序，时间复杂度：O((m+n)log(m+n))【快排】
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }*/

/*    //法二：利用额外空间的双指针排序，现有条件两数组已各自排好序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[m + n];
        int idx1 = 0;
        int idx2 = 0;
        int index = 0;
        while (idx1 < m && idx2 < n) {
            int t1 = nums1[idx1];
            int t2 = nums2[idx2];
            if (t1 <= t2) {
                res[index++] = t1;
                idx1++;
            } else {
                res[index++] = t2;
                idx2++;
            }
        }
        while (idx1 < m) {
            res[index++] = nums1[idx1++];
        }
        while (idx2 < n) {
            res[index++] = nums2[idx2++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }*/

    //法三：原地算法，利用逆向双指针，避免num1元素被覆盖，从最大值开始合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int cur = 0;
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 == -1) {
                cur = nums2[idx2--];
            } else if (idx2 == -1) {
                cur = nums1[idx1--];
            } else if (nums1[idx1] >= nums2[idx2]) {
                cur = nums1[idx1--];
            } else {
                cur = nums2[idx2--];
            }
            nums1[idx1 + idx2 + 2] = cur;
        }
    }
}
