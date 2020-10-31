// 10.30
// 463 Island Perimeter

/*
    给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
    网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
    岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    Output: 16
    Explanation: The perimeter is the 16 yellow stripes in the image above.

    Input: grid = [[1]]
    Output: 4

    Input: grid = [[1,0]]
    Output: 4

    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
*/

public class Solution201030 {
    public int islandPerimeter(int[][] grid) {
        /*
        // 找规律方法，只需要遍历每个格子左边和上边是否有陆地即可，有一个就消去两个边
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int temp=0;
                if(grid[i][j]==1){
                    temp=4;
                    if(i>0){
                        if(grid[i-1][j]==1)temp-=2;
                    }
                    if(j>0){
                        if(grid[i][j-1]==1)temp-=2;
                    }
                    result+=temp;
                }
            }
        }
        return result;
        */

        //DFS深度优先搜索方法
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0){
            return 1; // 如果是边界或者海洋，则当前边的贡献是1
        }
        if(grid[x][y]==2){
            return 0; // 如果已经遍历过当前边，则贡献为0
        }
        grid[x][y]=2;
        return dfs(grid,x-1,y)
                +dfs(grid,x+1,y)
                +dfs(grid,x,y-1)
                +dfs(grid,x,y+1);
    }

    public static void main(String[] args) {
        int [][]nums={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Solution201030 s =new Solution201030();
        s.islandPerimeter(nums);
    }
}
