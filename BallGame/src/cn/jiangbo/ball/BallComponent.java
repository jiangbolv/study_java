package cn.jiangbo.ball;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BallComponent {
	//设置X坐标
	private int x = -1;
	//设置y坐标
	private int y = -1;
	//设置图片
	private Image image = null;
	//设置图片速度
	private int speed = 5;
	
	
	/*
	 * 图片路径
	 */
	public BallComponent(String path) throws IOException{
		super();
		this.image = ImageIO.read(new File(path));
	}
	/*
	 * 构造器  画板
	 */
	public BallComponent(int panelWidth,int panelHeight,String path) throws IOException{
		super();
		//读取图片
		this.image= ImageIO.read(new File(path));
		//设置坐标
		this.x = (int) ((panelWidth-image.getWidth(null))/2);
	}
	/*
	 * 构造器  图像
	 */
	public BallComponent(String path,int x,int y)throws IOException{
		super();
		this.x= x;
		this.y= y;
		this.image= ImageIO.read(new File(path));
	}
	//获取x坐标
	public int getX(){
		return this.x;
	}
	//获取y坐标
	public int getY(){
		return this.y;
	}
	//获取图片速度
	public int getSpeed(){
		return this.speed;
	}
	//设置x坐标
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public Image getImage(){
		return this.image;
	}
}
