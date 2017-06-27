package cn.jiangbo.ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * 游戏界面
 */
public class BallFrame  extends JFrame{
	//定义JPanel的宽度
	private final int BALLPANEL_WIDTH=307;
	//定义JPanel的高度
	private final int BALLPANEL_HEIGHT=400;
	//定义画板
	private BallPanel ballPanel = null;
	//定义挡板
	private Image stick = null;
	//设置挡板的X坐标
	private int stickX = -1;
	//创建一个BallService实例
	private BallService service = null;
	//定义一个Timer
	Timer timer = null;
	
	/*
	 * 默认构造器
	 */
	public BallFrame() throws IOException{
		super();
		//初始化
		initialize();
		}
	/*
	 * 初始化界面
	 */
	public void initialize() throws IOException{
		//设置窗口的标题
		this.setTitle("桌面弹球游戏");
		//设置不可改变大小
		this.setResizable(false);
		//设置背景为黑色
		this.setBackground(Color.BLACK);
		//获取面板
		ballPanel= getBallPanel();
		//创建Ballservice的实例
		service = new BallService(this,BALLPANEL_WIDTH,BALLPANEL_HEIGHT);
		//定义每0.1秒执行一次监听
		ActionListener task = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//开始改变位置
				service.run();
				//刷新画板
				ballPanel.repaint();
				
			}
		};
		//如果timer不为空
		if(timer!=null){
			timer.restart();
		}else{
			//重新开一个timer
			timer = new Timer(100,task);
			timer.start();
		}
		this.add(ballPanel);
		//增加事件监听器
		KeyListener[] klarr = this.getKeyListeners();
		if(klarr.length==0){
			//定义键盘监听适配器
			KeyListener keyAdapter = new KeyAdapter() {
				public void keyPressed(KeyEvent ke){
					//改变挡板的位置
					service.setStickPos(ke);
				}
			};
			this.addKeyListener(keyAdapter);
		}
	}
	
	public BallPanel getBallPanel(){
		if(ballPanel ==null){
			ballPanel = new BallPanel();
			ballPanel.setPreferredSize(new Dimension(BALLPANEL_WIDTH, BALLPANEL_HEIGHT));
		}
		return ballPanel;
	}
	//定义一个JPanel内部类来完成画图功能
	public class BallPanel extends JPanel{
		public void paint(Graphics g){
			//画图
			service.draw(g);
		}
	}
	
	
	
}
