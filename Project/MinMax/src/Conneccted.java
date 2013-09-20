
public class Conneccted {
public static node[][] connect(node[][] board){
	
	board[4][0].connected.add(board[5][0]);
	board[4][0].connected.add(board[4][0]);
	board[5][0].connected=board[4][0].connected;
	
	board[3][1].connected.add(board[3][1]);
	board[3][1].connected.add(board[4][1]);
	board[3][1].connected.add(board[3][2]);
	board[3][1].connected.add(board[3][3]);
	board[3][1].connected.add(board[2][3]);
	board[4][1].connected=board[3][1].connected;
	board[3][2].connected=board[3][1].connected;
	board[3][3].connected=board[3][1].connected;
	board[2][3].connected=board[3][1].connected;
	
	board[0][2].connected.add(board[0][2]);
	board[0][2].connected.add(board[1][2]);
	board[1][2].connected=board[0][2].connected;
	
	board[4][2].connected.add(board[4][2]);
	board[4][2].connected.add(board[5][2]);
	board[5][2].connected=board[4][2].connected;
	
	board[3][4].connected.add(board[3][4]);
	board[3][4].connected.add(board[4][4]);
	board[3][4].connected.add(board[5][4]);
	board[3][4].connected.add(board[5][5]);
	board[4][4].connected=board[3][4].connected;
	board[5][4].connected=board[3][4].connected;
	board[5][5].connected=board[3][4].connected;
	
	board[2][5].connected.add(board[2][5]);
	board[2][5].connected.add(board[3][5]);
	board[2][5].connected.add(board[4][5]);
	board[3][5].connected=board[2][5].connected;
	board[4][5].connected=board[2][5].connected;
	
	for(int i=0;i<6;i++){
		for(int j=0;j<6;j++){
			if(!board[i][j].name.equals(".") && board[i][j].connected.size()==0){
				board[i][j].connected.add(board[i][j]);
			}
		}
	}
	return board;
	
}
}
