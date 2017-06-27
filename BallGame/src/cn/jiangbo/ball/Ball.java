package cn.jiangbo.ball;

import java.io.IOException;

public class Ball  extends BallComponent{
	//定义球的竖向速度
	private int speedY = 33;
	//定义球的横向速度
	private int speedX = 30;
 	//定义是否在运动
	private boolean started = false;
	//定义是否结束运动
	private boolean stop = false;
	/*
	 * 有参数的构造器
	 */
	
	public Ball(int panelWidth, int panelHeight, int offset,String path) throws IOException{
		super(panelWidth,panelHeight,path);
		//设置Y坐标
		this.setY(panelHeight-super.getImage().getHeight(null)-offset);
	}
	/*
	 * 设置横向速度
	 */
	public void setSpeedX(int speed){
		this.speedX= speed;
	}
	
	public int getSpeedX(){
		return this.speedX;
	}
	//设置竖向速度
	public void setSpeedY(int speed){
		this.speedY=speed;
	}
	public int getSpeedY(){
		return this.speedY;
	}
	//设置是否在动
	public void setStarted(boolean b){
		this.started = b;
	}
	
	//设置是否结束运动
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
