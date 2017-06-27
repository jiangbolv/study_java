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
 * ��Ϸ����
 */
public class BallFrame  extends JFrame{
	//����JPanel�Ŀ��
	private final int BALLPANEL_WIDTH=307;
	//����JPanel�ĸ߶�
	private final int BALLPANEL_HEIGHT=400;
	//���廭��
	private BallPanel ballPanel = null;
	//���嵲��
	private Image stick = null;
	//���õ����X����
	private int stickX = -1;
	//����һ��BallServiceʵ��
	private BallService service = null;
	//����һ��Timer
	Timer timer = null;
	
	/*
	 * Ĭ�Ϲ�����
	 */
	public BallFrame() throws IOException{
		super();
		//��ʼ��
		initialize();
		}
	/*
	 * ��ʼ������
	 */
	public void initialize() throws IOException{
		//���ô��ڵı���
		this.setTitle("���浯����Ϸ");
		//���ò��ɸı��С
		this.setResizable(false);
		//���ñ���Ϊ��ɫ
		this.setBackground(Color.BLACK);
		//��ȡ���
		ballPanel= getBallPanel();
		//����Ballservice��ʵ��
		service = new BallService(this,BALLPANEL_WIDTH,BALLPANEL_HEIGHT);
		//����ÿ0.1��ִ��һ�μ���
		ActionListener task = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ʼ�ı�λ��
				service.run();
				//ˢ�»���
				ballPanel.repaint();
				
			}
		};
		//���timer��Ϊ��
		if(timer!=null){
			timer.restart();
		}else{
			//���¿�һ��timer
			timer = new Timer(100,task);
			timer.start();
		}
		this.add(ballPanel);
		//�����¼�������
		KeyListener[] klarr = this.getKeyListeners();
		if(klarr.length==0){
			//������̼���������
			KeyListener keyAdapter = new KeyAdapter() {
				public void keyPressed(KeyEvent ke){
					//�ı䵲���λ��
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
	//����һ��JPanel�ڲ�������ɻ�ͼ����
	public class BallPanel extends JPanel{
		public void paint(Graphics g){
			//��ͼ
			service.draw(g);
		}
	}
	
	
	
}
