package cn.jiangbo.ball;

import java.io.IOException;

public class Stick extends BallComponent{
	//���嵲���ƶ����ٶ�
	public static final int SPEED = 20;
	//���嵲���ʼ�ĳ���
	private int preWidth = 0;
	//�в����Ĺ�����
	public Stick(int panelWidth,int panelHeight,String path) throws IOException {
		//���ø��๹����
		super(panelWidth,panelHeight,path);
		//����y����
		this.setY(panelHeight - super.getImage().getHeight(null));
		//����ԭ���ĳ���
		this.preWidth = super.getImage().getWidth(null);
	}
	//��ȡ��ʼ����
	public int getPreWidth(){
		return this.preWidth;
	}
	//���ó�ʼ����
	public void setPreWidth(int preWidth){
		this.preWidth=preWidth;
	}
	
}
