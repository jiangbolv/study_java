package cn.jiangbo.ball;

import java.io.IOException;

import javax.swing.JFrame;

/*
 * 游戏入口类
 */
public class BallGame {
	/*
	 * 开始游戏
	 */
	public static void main(String[] args) throws IOException{
		BallFrame ballFrame = new BallFrame();
		ballFrame.pack();
		ballFrame.setVisible(true);
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
