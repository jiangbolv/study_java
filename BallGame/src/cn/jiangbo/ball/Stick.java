package cn.jiangbo.ball;

import java.io.IOException;

public class Stick extends BallComponent{
	//定义挡板移动的速度
	public static final int SPEED = 20;
	//定义挡板初始的长度
	private int preWidth = 0;
	//有参数的构造器
	public Stick(int panelWidth,int panelHeight,String path) throws IOException {
		//调用父类构造器
		super(panelWidth,panelHeight,path);
		//设置y坐标
		this.setY(panelHeight - super.getImage().getHeight(null));
		//设置原本的长度
		this.preWidth = super.getImage().getWidth(null);
	}
	//获取初始长度
	public int getPreWidth(){
		return this.preWidth;
	}
	//设置初始长度
	public void setPreWidth(int preWidth){
		this.preWidth=preWidth;
	}
	
}
