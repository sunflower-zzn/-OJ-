// 11.14
// 1122 Relative Sort Array

/*
    给你两个数组，arr1 和 arr2，

    arr2 中的元素各不相同
    arr2 中的每个元素都出现在 arr1 中
    对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    Output: [2,2,2,1,4,3,3,9,6,7,19]
     
    Constraints:
    arr1.length, arr2.length <= 1000
    0 <= arr1[i], arr2[i] <= 1000
    Each arr2[i] is distinct.
    Each arr2[i] is in arr1.

*/

import java.util.*;

public class Solution201114 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        /*
        //比较笨的办法，需要注意的是，不建议使用Arrays的排序以及ArrayList.asList方法
        //会涉及到十分痛苦的类型转换，JAVA泛型老折磨了！
        List<Integer> cmparr1=new ArrayList<Integer>();
        List<Integer> cmparr2=new ArrayList<Integer>();
        for(int num:arr1)cmparr1.add(num);
        for(int num:arr2)cmparr2.add(num);
        cmparr1.sort(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                int idx1 = cmparr2.indexOf(num1);
                int idx2 = cmparr2.indexOf(num2);
                if (idx1 == -1 && idx2 == -1) return num1 - num2;
                else if (idx1 == -1) return 1;
                else if (idx2 == -1) return -1;
                else return idx1 - idx2;
            }
        });
        for(int i=0;i<cmparr1.size();i++){
            arr1[i]=cmparr1.get(i);
        }
        return arr1;
        */

        /*
        //参考官方题解及评论区，给出自定义排序的优化写法
        List<Integer> arrlist=new ArrayList<Integer>();
        Map<Integer,Integer> arrmap=new HashMap<Integer, Integer>();
        int temp=arr1[0];
        for(int num:arr1){
            arrlist.add(num);
            temp= Math.max(num, temp);
        }
        int maxnum = temp;
        for(int i=0;i<arr2.length;i++)arrmap.put(arr2[i],i);
        arrlist.sort((x, y)->{
            if(arrmap.containsKey(x) || arrmap.containsKey(y))return arrmap.getOrDefault(x, maxnum +1)-arrmap.getOrDefault(y, maxnum +1);
            return x-y;
        });
        for(int i=0;i<arrlist.size();i++){
            arr1[i]=arrlist.get(i);
        }
        return arr1;
        */

        //鉴于自定义排序的时间复杂度很高，所以采用计数循环的思路【以时间换空间】
        //1.遍历arr1，记录每个数出现的次数，记录数组长度为【1001】
        //2.将arr2中出现的数加入结果数组
        //3.将arr2中没出现的数加入结果数组（记录数组本身就是升序的，0-1001）
        int[] res = new int[arr1.length];
        int index = 0;
        int[] times = new int[1001];  //因为数范围在0-1000
        for (int num : arr1) times[num]++;  //遍历arr1
        for (int num : arr2) {          //遍历arr2
            while (times[num] > 0) {
                res[index++] = num;
                times[num]--;
            }
        }
        for (int i = 0; i < times.length; i++) {
            while (times[i] > 0) {
                res[index++] = i;
                times[i]--;
            }
        }
        return res;

    }
}
