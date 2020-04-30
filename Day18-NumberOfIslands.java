class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        if(grid==null || grid.length==0){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    //count+=dfs(grid,i,j);
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j){
       /* if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return ;
        }*/
        int m = grid.length;
        int n = grid[0].length;
        
        //equivalent to right,down,up,left
        int [][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        //grid[i][j]='0';
        while(!q.isEmpty()){
            int[] cur = q.poll();
             if(cur[0]<0 || cur[0]>=m || cur[1]<0 || cur[1]>=n || grid[cur[0]][cur[1]]=='0'){
                 continue;
             }
            grid[cur[0]][cur[1]]='0';
            for(int[] direction:directions){
                int x=cur[0]+direction[0];
                int y=cur[1]+direction[1];
               
                    q.add(new int[]{x,y});
            }
        }
    }
    /*public int dfs(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;
    }*/
}