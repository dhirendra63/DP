 public int solve(int[][]matrix,int row,int col,int[][]dp,int prev){
        int m=matrix.length;
        int n=matrix[0].length;
        if(row<0||row==m||col<0||col==n||matrix[row][col]<=prev)return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int up=solve(matrix,row-1,col,dp,matrix[row][col]);
        int down=solve(matrix,row+1,col,dp,matrix[row][col]);
        int left=solve(matrix,row,col-1,dp,matrix[row][col]);
        int right=solve(matrix,row,col+1,dp,matrix[row][col]);
        int ans=1+Math.max(left,Math.max(right,Math.max(up,down)));
        return dp[row][col]=ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        
        int row=matrix.length;
        int col=matrix[0].length;
        int[][]dp=new int[row+1][col+1];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],-1);
        }
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max=Math.max(max,solve(matrix,i,j,dp,-1));
            }
        }
        return max;
    }
