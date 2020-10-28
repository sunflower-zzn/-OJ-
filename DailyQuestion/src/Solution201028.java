// 10.28
// 1207 Unique Number of Occurrences

/*
    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

    Input: arr = [1,2,2,1,1,3]
    Output: true

    Input: arr = [1,2]
    Output: false

    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
    Output: true

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000
*/

import java.util.*;

public class Solution201028 {
    public boolean uniqueOccurrences(int[] arr) {
        //map统计每个元素出现次数
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //set去除出现次数中的重复
        Set<Integer> set=new HashSet<>();
        for(Map.Entry<Integer,Integer> x:map.entrySet()){
            set.add(x.getValue());
        }
        //比较set和map即可
        return map.size()==set.size();

    }
}
