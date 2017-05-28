package leetcode;

/**
 * Created by lukCy on 2017/4/20.
 */
public class _547FriendsCircles {
    public int findCircleNum(int[][]M){
        int n = M.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++){
            if (!visited[i]) {
                count++;
                dfsM(i, M, visited);
            }
        }
        return count;
    }
    public void dfsM(int i,int[][] M,boolean[] visited){
        visited[i] = true;

        for (int j=0;j<M.length;j++){
            if (i == j) continue;;
            if (M[i][j] == 1 && !visited[j])
                dfsM(j,M,visited);
        }
    }


    public static void main(String[] args) {
        int[][] M = {{1,1,0},{1,1,1},{0,1,1}};int n = M.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n-1;j++){
                System.out.print(String.valueOf(M[i][j])+" ");
            }
            System.out.println(String.valueOf(M[i][n-1]));
        }
        System.out.println("the circleNum is "+String.valueOf(new _547FriendsCircles().findCircleNum(M)));
    }
}
