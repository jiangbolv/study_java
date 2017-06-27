package cn.jiangbo.ball;

import java.io.IOException;

public class ShortMagic extends Magic{
	
	//������
	public ShortMagic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	public void magicDo(Stick stick){
		double imageWidth = stick.getImage().getWidth(null);
		if(stick.getPreWidth()>= imageWidth){
			//������Ŀ�ȸ�Ϊһ��
			stick.setPreWidth((int) (stick.getPreWidth()*0.5));
		}
	}
}
