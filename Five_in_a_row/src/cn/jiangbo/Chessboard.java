package cn.jiangbo;

public class Chessboard {
	//����һ����λ����䵱����
	private String[][] board;
	//�������̵Ĵ�С
	public static final int BOARD_SIZE=20;
	/*
	 * ��ʼ������
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
	 * �ڿ���̨������̵ķ���
	 */
	public void printBoard()
	{
		for(int i=0;i<BOARD_SIZE;i++){
			for(int j=0;j<BOARD_SIZE;j++){
				//��ӡ��󲻻���
				System.out.print(board[i][j]);
			}
			//��ӡ��һ������Ԫ�ػ�һ��
		System.out.println("\n");
		}
	}
	
	/*
	 * ������λ�ø�ֵ
	 * @param posX
	 * 			X����
	 * @param posY
	 * 			Y����
	 * @param chessman
	 * 			����
	 */
	public void setBoard(int posX,int posY,String chessman){
		this.board[posX][posY]= chessman;
	}
	/*
	 * ��������
	 */
	public String[][] getBoard(){
		return this.board;
	}
}
