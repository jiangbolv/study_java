package cn.jiangbo.ball;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BallComponent {
	//����X����
	private int x = -1;
	//����y����
	private int y = -1;
	//����ͼƬ
	private Image image = null;
	//����ͼƬ�ٶ�
	private int speed = 5;
	
	
	/*
	 * ͼƬ·��
	 */
	public BallComponent(String path) throws IOException{
		super();
		this.image = ImageIO.read(new File(path));
	}
	/*
	 * ������  ����
	 */
	public BallComponent(int panelWidth,int panelHeight,String path) throws IOException{
		super();
		//��ȡͼƬ
		this.image= ImageIO.read(new File(path));
		//��������
		this.x = (int) ((panelWidth-image.getWidth(null))/2);
	}
	/*
	 * ������  ͼ��
	 */
	public BallComponent(String path,int x,int y)throws IOException{
		super();
		this.x= x;
		this.y= y;
		this.image= ImageIO.read(new File(path));
	}
	//��ȡx����
	public int getX(){
		return this.x;
	}
	//��ȡy����
	public int getY(){
		return this.y;
	}
	//��ȡͼƬ�ٶ�
	public int getSpeed(){
		return this.speed;
	}
	//����x����
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
