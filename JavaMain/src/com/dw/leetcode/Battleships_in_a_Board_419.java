package com.dw.leetcode;

/*
 * idea: input assume that all battleship having space between them
 * 
 * so count top left array will be number of ship.
 */
public class Battleships_in_a_Board_419 {
	
    public int countBattleships(char[][] board) {
        if(board.length == 0) return 0;
        
    	int m = board.length; int n= board[0].length;
    	
    	int counter = 0;
    	for(int i=0;i<m;i++)
    		for(int j=0;j<n;j++) {
    			if(board[i][j] == '.') continue;
    			if(i>0 && board[i-1][j] == 'X') continue;
    			if(j>0 && board[i][j-1] == 'X') continue;
    			counter ++;
    		}
    	
    	return counter;
    }

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
