/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author dhawa
 */
import java.lang.*;

public class GameBoard {

	private int[][] solution;
	private int[][] initial;
	private int[][] player;
	public GameBoard(int N,int K) {
            
                Boards b = new Boards(N,K);
                b.fillValues();
                player = new int[9][9];
                solution = new int[9][9];
                initial = new int[9][9];
                for(int i = 0;i < 9;i++){
                    for(int j = 0;j < 9;j++){
                        solution[i][j] = b.mat_ans[i][j];
                        initial[i][j] = b.mat[i][j];
                    }
                }
//		solution = new int[][]
//		{
//			{5,3,8,4,6,1,7,9,2},
//			{6,9,7,3,2,5,8,1,4},
//			{2,1,4,7,8,9,5,6,3},
//			{9,4,1,2,7,8,6,3,5},
//			{7,6,2,1,5,3,9,4,8},
//			{8,5,3,9,4,6,1,2,7},
//			{3,8,9,5,1,2,4,7,6},
//			{4,2,6,8,9,7,3,5,1},
//			{1,7,5,6,3,4,2,8,9}
//		};
//
//		initial = new int[][]
//		{
//			{0,0,0,4,0,0,0,9,0},
//			{6,0,7,0,0,0,8,0,4},
//			{0,1,0,7,0,9,0,0,3},
//			{9,0,1,0,7,0,0,3,0},
//			{0,0,2,0,0,0,9,0,0},
//			{0,5,0,0,4,0,1,0,7},
//			{3,0,0,5,0,2,0,7,0},
//			{4,0,6,0,0,0,3,0,1},
//			{0,7,0,0,0,4,0,0,0}
//		};

              
        }

	public int[][] getSolution() {
		return solution;
	}

	public int[][] getInitial() {
		return initial;
	}

	public int[][] getPlayer() {
		return player;
	}

	public void modifyPlayer(int val, int col, int row) {
		if(initial[row][col] == 0) 
			player[row][col] = val;
	}
        
        public boolean checkForSuccess() {
		for(int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) { 
				if(initial[row][col] == 0) {
					if(player[row][col] != solution[row][col]) {
						return false;
					}
				}
			}
		}
		return true;
    }

}

