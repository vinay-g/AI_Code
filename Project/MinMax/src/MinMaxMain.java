import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class MinMaxMain {
	static Print p=new Print();
	public static void main(String[] args) {
		String initBoard[][]={	{"W",".","W",".","W","W"},
				{".","W",".","B","B","."},
				{"B","B","W","B","W","W"},
				{"W",".","B","B",".","B"},
				{".","B",".","W","W","W"},
				{"B",".","B","B","B","W"}	};

		int liberty[][]=	{	{ 2 , 0 , 3 , 0 , 2 , 2 },
				{ 0 , 3 , 0 , 3 , 3 , 0 },
				{ 1 , 1 , 1 , 6 , 2 , 2 },
				{ 2 , 0 , 6 , 6 , 0 , 1 },
				{ 0 , 4 , 0 , 2 , 2 , 2 },
				{ 2 , 0 , 2 , 2 , 2 , 2 }	};




		node [][]board=new node[6][6];

		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				node temp=new node();
				temp.name=initBoard[j][i];
				temp.liberty=liberty[j][i];
				temp.dead=false;
				board[i][j]=temp;
			}
		}
		iterator(board,0,"B");		
		
		System.out.println(MaxCost);
	}
	public static node[][] recalLiberty(node [][]board,int i,int j,char player){

		for(int k=0;k<6;k++){
			for(int l=0;l<6;l++){
				if(board[k][l].name.equals("W")||board[k][l].name.equals("B")){
					int liberty=0;
					if((k-1)>=0 && board[k-1][l].name.equals(".")){
						liberty++;
					}
					if((k+1)<6 && board[k+1][l].name.equals(".")){
						liberty++;
					}
					if((l-1)>=0 && board[k][l-1].name.equals(".")){
						liberty++;
					}
					if((l+1)<6 && board[k][l+1].name.equals(".")){
						liberty++;
					}
					board[k][l].liberty=liberty;
				}
			}
		}	
		return board;

	}
	public static boolean checkLiberty(node[][] board,int i, int j){
		String type=board[i][j].name;
		if((i-1)>=0 && board[i-1][j].name.equals(type) &&  board[i-1][j].visited==false){
			board[i-1][j].visited=true;
			if(board[i-1][j].liberty==0){
				if(checkLiberty(board,i-1,j)){
					return true;
				}
			}
			else
			{
				return true;
			}

		}
		if((i+1)<6 && board[i+1][j].name.equals(type) && board[i+1][j].visited==false){
			board[i+1][j].visited=true;
			if(board[i+1][j].liberty==0){
				if(checkLiberty(board,i+1,j)){
					return true;
				}
			}
			else
			{
				return true;
			}
		}
		if((j-1)>=0 && board[i][j-1].name.equals(type) && board[i][j-1].visited==false){
			board[i][j-1].visited=true;
			if(board[i][j-1].liberty==0){
				if(checkLiberty(board,i,j-1)){
					return true;
				}
			}
			else
			{
				return true;
			}
		}
		if((j+1)<6 && board[i][j+1].name.equals(type) && board[i][j+1].visited==false){
			board[i][j+1].visited=true;
			if(board[i][j+1].liberty==0){
				if(checkLiberty(board,i,j+1)){
					return true;
				}
			}
			else
			{
				return true;
			}
		}
		return false;
	}
	public static node[][] resetVisited(node[][] board){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				board[i][j].visited=false;
			}
		}
		return board;
	}
	public static node[][] invalidate(node[][] board){

		for(int k=0;k<6;k++){
			for(int l=0;l<6;l++){
				if(!board[k][l].name.equals(".") && board[k][l].liberty==0){
					if(!checkLiberty(board,k,l)){
						board[k][l].name="X";
						board[k][l].dead=true;
						board=resetVisited(board);
					}
					else{
						board=resetVisited(board);
					}
				}
			}
		}


		return board;
	}

	//	public static int iterator(node[][] board,String type,int depth){
	//		System.out.print(depth);
	//		if(depth==4){
	//			int Bcount=0;
	//			int Wcount=0;
	//			for(int i=0;i<6;i++){
	//				for(int j=0;j<6;j++){
	//					if(board[i][j].name.equals("B")){
	//						Bcount++;
	//					}
	//					else if(board[i][j].name.equals("W")){
	//						Wcount++;
	//					}
	//				}
	//			}
	//			System.out.println("Cost:"+(Bcount-Wcount));
	//			return (Bcount-Wcount);
	//		}
	//		for(int i=0;i<6;i++){
	//			for(int j=0;j<6;j++){
	//				if(board[i][j].name.equals(".")){
	//					board[i][j].name=type;
	//					board=recalLiberty(board, i, j);
	//					if(type.endsWith("B")){
	//					iterator(board,"W", ++depth);
	//					}
	//					else{
	//					iterator(board,"B", ++depth);	
	//					}
	//				}
	//			}
	//		}
	//		return 0;
	//	}
	
	public static node[][] copy(node[][] input) {
	      node[][] target = new node[6][6];
	      for(int i=0;i<6;i++){
	    			for(int j=0;j<6;j++){
	    				node temp=new node();
	    				temp.visited=input[i][j].visited;
	    				temp.name=input[i][j].name;
	    				temp.liberty=input[i][j].liberty;
	    				temp.dead=input[i][j].dead;
	    				target[i][j]=temp;
	    			}		
	      }
	      return target;
	}
	static int MaxCost=0;
	public static void iterator(node[][] board,int depth,String type){
		if(depth==4){
			int Bcount=0;
			int Wcount=0;
			for(int i=0;i<6;i++){
				for(int j=0;j<6;j++){
					if(board[i][j].name.equals("B")){
						Bcount++;
					}
					else if(board[i][j].name.equals("W")){
						Wcount++;
					}
				}
			}
			p.board(board);
			if((Bcount-Wcount)>MaxCost){
				MaxCost=Bcount-Wcount;
			}
			System.out.println("Cost:"+(Bcount-Wcount));
			return;
		}
	//	System.out.println("-------------------------------------------------");
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				if(board[i][j].name.equals(".")){
					node[][] tempboard=copy(board);
					tempboard[i][j].name=type;
					
					if(type.equals("B")){
						tempboard=recalLiberty(tempboard, i, j,'B');
						tempboard=invalidate(tempboard);
					//	p.board(tempboard);
						iterator(tempboard,depth+1,"W");
					}
					else{
						tempboard=recalLiberty(tempboard, i, j,'W');
						tempboard=invalidate(tempboard);
					//	p.board(tempboard);
						iterator(tempboard,depth+1,"B");
					}
					System.out.println();
				}
			}
		}
	}
}
