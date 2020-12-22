// 11.06
// 1356 Sort Integers by The Number of 1 Bits

/*
    给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
    如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
    请你返回排序后的数组。

    Input: arr = [0,1,2,3,4,5,6,7,8]
    Output: [0,1,2,4,8,3,5,6,7]
    Explantion: [0] is the only integer with 0 bits.
    [1,2,4,8] all have 1 bit.
    [3,5,6] have 2 bits.
    [7] has 3 bits.
    The sorted array by bits is [0,1,2,4,8,3,5,6,7]

    Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
    Output: [1,2,4,8,16,32,64,128,256,512,1024]
    Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.

    Input: arr = [10000,10000]
    Output: [10000,10000]

    Input: arr = [2,3,5,7,11,13,17,19]
    Output: [2,3,5,17,7,11,13,19]

    Input: arr = [10,100,1000,10000]
    Output: [10,100,10000,1000]

    Constraints:
    1 <= arr.length <= 500
    0 <= arr[i] <= 10^4
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution201106 {
    public int[] sortByBits(int[] arr) {
/*
        //排序函数方法，定义排序函数，利用JAVA中的bitcount函数计算1的个数
        if (arr.length == 0) return arr;
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        list.sort((num1, num2) -> {
            int b1 = Integer.bitCount(num1);
            int b2 = Integer.bitCount(num2);
            return b1 != b2 ? b1 - b2 : num1 - num2; // 三目操作符
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = list.get(i);
        }
        return res;
*/

        //注意到0 <= arr[i] <= 10^4，计算其1的个数并让其二进制标识做高位（只需要超出10^4即可）
        //然后其本身做低位进行数组排序即可，这样先比较1的个数，在比较数的大小
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.bitCount(arr[i])*100000+arr[i];  //前移5位
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i] % 100000;  // 取低位，即数组原值
        }
        return arr;
    }
}
