package cn.jiangbo.ball;

import java.io.IOException;

public  abstract class Magic extends BallComponent{
	/*
	 * �ṩ��������õĹ�����
	 */
	public Magic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	//���ߵĹ���
	public abstract void magicDo(Stick stick);
}
