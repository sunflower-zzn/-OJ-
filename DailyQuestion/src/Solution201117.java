// 11.17
// 1030 Matrix Cells in Distance Order

/*
    给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
    另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
    返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

    Input: R = 1, C = 2, r0 = 0, c0 = 0
    Output: [[0,0],[0,1]]
    Explanation: The distances from (r0, c0) to other cells are: [0,1]

    Input: R = 2, C = 2, r0 = 0, c0 = 1
    Output: [[0,1],[0,0],[1,1],[1,0]]
    Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
    The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

    Input: R = 2, C = 3, r0 = 1, c0 = 2
    Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
    Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
    There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].    

    Note:
    1 <= R <= 100
    1 <= C <= 100
    0 <= r0 < R
    0 <= c0 < C

*/

import java.util.*;

public class Solution201117 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] p0={r0,c0};
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                map.put(i*C+j,Math.abs(r0-i)+Math.abs(c0-j));
            }
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        int[][] res=new int[R*C][2];
        int index=0;
        for(Map.Entry<Integer,Integer> temp:list){
            res[index][0]=temp.getKey()/C;
            res[index][1]=temp.getKey()%C;
            index++;
        }
        return res;
    }
}
