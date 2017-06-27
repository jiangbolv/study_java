package cn.jiangbo.ball;

import java.io.IOException;

/*
 * ש����
 */
public class Brick extends BallComponent{
	//�������
	private Magic magic = null;
	//����һ��boolean�������ñ����Ƿ���Ч
	private boolean disable = false;
	public static final int MAGIC_LONG_TYPE = 1;
	public static final int MAGIC_SHORT_TYPE = 2;
	//������
	public Brick(String path,int type,int x,int y) throws IOException{
		super(path);
		if(type ==Brick.MAGIC_LONG_TYPE){
			this.magic= new LongMagic("img/long.gif",x,y);
			
		}else if(type== Brick.MAGIC_SHORT_TYPE){
			this.magic = new ShortMagic("img/short.gif",x,y);
		}
	}
	
	//���ñ�����û��Ч
	public boolean isDisable(){
		return this.disable;
	}
	public void setDisable( boolean disable){
		this.disable= disable;
	}
	//��ȡ����
	public Magic getMagic(){
		return this.magic;
	}
	//���õ���
	public void setMagic(Magic magic){
		this.magic= magic;
	}
}
