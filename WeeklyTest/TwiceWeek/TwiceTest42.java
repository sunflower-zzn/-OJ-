//第42次双周赛

import java.util.ArrayList;
import java.util.List;

public class TwiceTest42 {
    //1700 无法吃午餐的学生数量
    //https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
    public int countStudents(int[] students, int[] sandwiches) {
        int q=0;
        List<Integer> queue=new ArrayList<>();
        for(int stu:students)queue.add(stu);
        int len=students.length;
        while(len>0){
            int templen=len;
            for(int i=0;i<templen;i++){
                if(queue.get(0)==sandwiches[q]){
                    q++;
                    queue.remove(0);
                    len--;
                }
                else{
                    int t=queue.remove(0);
                    queue.add(t);
                }
            }
            if(len==templen)return len;
        }
        return 0;
    }

    //1701 平均等待时间
    //https://leetcode-cn.com/problems/average-waiting-time/
    public double averageWaitingTime(int[][] customers) {
        long res=0;
        long start=0;
        for(int i=0;i<customers.length;i++){
            if(customers[i][0]>=start){
                start=customers[i][0]+customers[i][1];
            }
            else{
                start=start+customers[i][1];
            }
            res+=start-customers[i][0];
        }
        return (double)res/customers.length;
    }

    //1702 修改后的最大二进制字符串
    //https://leetcode-cn.com/problems/maximum-binary-string-after-change/
    public String maximumBinaryString(String binary) {
        return "";
    }


    //1703. 得到连续 K 个 1 的最少相邻交换次数
    //https://leetcode-cn.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
    public int minMoves(int[] nums, int k) {
        return 0;
    }


}
