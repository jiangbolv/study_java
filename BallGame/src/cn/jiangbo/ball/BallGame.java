package cn.jiangbo.ball;

import java.io.IOException;

import javax.swing.JFrame;

/*
 * ��Ϸ�����
 */
public class BallGame {
	/*
	 * ��ʼ��Ϸ
	 */
	public static void main(String[] args) throws IOException{
		BallFrame ballFrame = new BallFrame();
		ballFrame.pack();
		ballFrame.setVisible(true);
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
