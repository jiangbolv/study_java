package cn.jiangbo.ball;

import java.io.IOException;

/*
 * ʹ����䳤�ĵ�����
 */
public class LongMagic extends Magic{
	//������
	public LongMagic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	//���ߵĹ��ܣ��䳤
	public void magicDo(Stick stick){
		double imageWidth = stick.getImage().getWidth(null);
		//�������û�б䳤��
		if(stick.getPreWidth()<= imageWidth){
			//������ĳ��ȸ�Ϊ˫��
			stick.setPreWidth((int)(stick.getPreWidth()*2));
		}
	}
}
