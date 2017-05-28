package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lukCy on 2017/4/14.
 */
public class _130SurroundedRegion {

    public void Solve(char[][] board){
        if(board == null || board.length == 0)
            return;
        Coordinate coordinate_1 = null;//用以保存边缘o节点坐标
        Coordinate coordinate_2 = null;//用以保存边缘o节点附近的o节点的坐标
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        //BFS遍历边缘的o节点，保存其坐标
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (i==0 || i==(board.length-1) || j==0 || j==(board[0].length-1)){
                    if (board[i][j] == 'o'){
                        coordinate_1  = new Coordinate(i,j);
                        queue.add(coordinate_1);
                    }
                }
            }
        }
        int x,y,index;
        //BFS遍历边缘o节点四周的o节点,这些o节点的值都暂时改为y，后续遍历一遍把所有剩下的o都改为x，再把y改回o
        while (!queue.isEmpty()){
            coordinate_2 = queue.poll();
            x = coordinate_2.x;
            y = coordinate_2.y;
            board[x][y] = 'y';

            index = x-1;
            if (index>=0 && board[index][y] == 'o')
                queue.add(new Coordinate(index,y));
            index = x+1;
            if (index<=board[0].length-1 && board[index][y] == 'o')
                queue.add(new Coordinate(index,y));
            index = y-1;
            if (index>=0 && board[x][index] == 'o')
                queue.add(new Coordinate(x,index));
            index = y+1;
            if (index<=board.length-1 && board[x][index] == 'o')
                queue.add(new Coordinate(x,index));
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j] == 'o')
                    board[i][j] = 'x';
                if (board[i][j] == 'y')
                    board[i][j] = 'o';
            }
        }

    }
    public static void main(String[] args) {
        _130SurroundedRegion test = new _130SurroundedRegion();
        char[][] board = {{'x','x','x','x'},{'x','o','o','x'},{'x','x','o','x'},{'x','o','x','x'}};
        System.out.println("hangnum is "+board.length+" and "+"lienum is "+board[0].length);
        for (int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }
        test.Solve(board);
        for (int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }
    }
}

