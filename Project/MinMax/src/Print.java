public class Print {
	public void board(node[][] board){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(board[i][j].name+" ");
			}
			System.out.println();
		}
	}
	public void liberty(node[][] board){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(board[i][j].liberty+" ");
			}
			System.out.println();
		}
	}	
	public void connected(node[][] board){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(board[i][j].connected.size()+" ");
			}
			System.out.println();
		}
	}	
}
