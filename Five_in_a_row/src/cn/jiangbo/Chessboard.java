package cn.jiangbo;

public class Chessboard {
	//定义一个二位数组充当棋盘
	private String[][] board;
	//定义棋盘的大小
	public static final int BOARD_SIZE=20;
	/*
	 * 初始化棋盘
	 * @return void
	 */
	
	public void initBoard()
	{
		board = new String[BOARD_SIZE][BOARD_SIZE];
		for(int i=0;i<BOARD_SIZE;i++)
		{
			for(int j=0;j<BOARD_SIZE;j++){
				board[i][j] = "+";
			}
		}
	}
	
	public void test(){
		Object[][] array = new Object[10][10];
		for(int i= 0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				array[i][j] = new Object();
			}
		}
	}
	/*
	 * 在控制台输出棋盘的方法
	 */
	public void printBoard()
	{
		for(int i=0;i<BOARD_SIZE;i++){
			for(int j=0;j<BOARD_SIZE;j++){
				//打印完后不换行
				System.out.print(board[i][j]);
			}
			//打印完一行数组元素换一行
		System.out.println("\n");
		}
	}
	
	/*
	 * 给棋盘位置赋值
	 * @param posX
	 * 			X坐标
	 * @param posY
	 * 			Y坐标
	 * @param chessman
	 * 			棋子
	 */
	public void setBoard(int posX,int posY,String chessman){
		this.board[posX][posY]= chessman;
	}
	/*
	 * 返回棋盘
	 */
	public String[][] getBoard(){
		return this.board;
	}
}
