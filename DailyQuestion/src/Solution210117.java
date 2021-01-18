// 1.17
// 1232. Check If It Is a Straight Line（缀点成线）

/*
    在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
    请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

    提示：
    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates 中不含重复的点
*/

public class Solution210117 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;       //不超过两个点一定构成线
        boolean flagx = true, flagy = true;              //验证是否与坐标轴平行
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] != coordinates[i - 1][0]) flagx = false;
            if (coordinates[i][1] != coordinates[i - 1][1]) flagy = false;
        }
        if (flagx || flagy) return true;
        int x = coordinates[1][0] - coordinates[0][0];  //通过计算斜率判断是否同线，注意要跟
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int tx = coordinates[i][0] - coordinates[0][0];
            int ty = coordinates[i][1] - coordinates[0][1];
            if ((double) ty / y != (double) tx / x) return false;
        }
        return true;
    }
}
