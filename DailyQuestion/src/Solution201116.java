// 11.16
// 406 Queue Reconstruction by Height

/*
    假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

    注意：
    总人数少于1100人。

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Solution201116 {
    public int[][] reconstructQueue(int[][] people) {
        //先对输入数组排序，h升序，k降序 从头循环遍历
        //当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值
        //如果有多个人高度相同，要按照k值从大到小领取索引值
        /*  示例：
            [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
            [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
            [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
            [ 1, 3, 5 ]          [ 6, 1 ] 3
            [ 1, 5 ]             [ 7, 1 ] 5
            [ 1 ]                [ 7, 0 ] 1
            [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
        */
        List<int[]> list = new ArrayList<>(Arrays.asList(people));
        list.sort((o1, o2) -> o1[0]!=o2[0]?o1[0]-o2[0]:o2[1]-o1[1]);
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<people.length;i++)ans.add(i);
        int[][] res=new int[people.length][2];
        for(int i=0;i<people.length;i++){
            res[ans.get(list.get(i)[1])]=list.get(i);
            ans.remove(list.get(i)[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution201116 s=new Solution201116();
        s.reconstructQueue(people);
    }

}
