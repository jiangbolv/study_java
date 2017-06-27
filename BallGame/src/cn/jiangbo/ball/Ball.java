package cn.jiangbo.ball;

import java.io.IOException;

public class Ball  extends BallComponent{
	//������������ٶ�
	private int speedY = 33;
	//������ĺ����ٶ�
	private int speedX = 30;
 	//�����Ƿ����˶�
	private boolean started = false;
	//�����Ƿ�����˶�
	private boolean stop = false;
	/*
	 * �в����Ĺ�����
	 */
	
	public Ball(int panelWidth, int panelHeight, int offset,String path) throws IOException{
		super(panelWidth,panelHeight,path);
		//����Y����
		this.setY(panelHeight-super.getImage().getHeight(null)-offset);
	}
	/*
	 * ���ú����ٶ�
	 */
	public void setSpeedX(int speed){
		this.speedX= speed;
	}
	
	public int getSpeedX(){
		return this.speedX;
	}
	//���������ٶ�
	public void setSpeedY(int speed){
		this.speedY=speed;
	}
	public int getSpeedY(){
		return this.speedY;
	}
	//�����Ƿ��ڶ�
	public void setStarted(boolean b){
		this.started = b;
	}
	
	//�����Ƿ�����˶�
	public void setStop(boolean b){
		this.stop = b;
	}
	public boolean isStarted(){
		return this.started;
	}
	public boolean isStop(){
		return this.stop;
	}
}
