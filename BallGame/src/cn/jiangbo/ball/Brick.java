package cn.jiangbo.ball;

import java.io.IOException;

/*
 * 砖块类
 */
public class Brick extends BallComponent{
	//定义道具
	private Magic magic = null;
	//定义一个boolean变量设置本类是否有效
	private boolean disable = false;
	public static final int MAGIC_LONG_TYPE = 1;
	public static final int MAGIC_SHORT_TYPE = 2;
	//构造器
	public Brick(String path,int type,int x,int y) throws IOException{
		super(path);
		if(type ==Brick.MAGIC_LONG_TYPE){
			this.magic= new LongMagic("img/long.gif",x,y);
			
		}else if(type== Brick.MAGIC_SHORT_TYPE){
			this.magic = new ShortMagic("img/short.gif",x,y);
		}
	}
	
	//设置本类有没有效
	public boolean isDisable(){
		return this.disable;
	}
	public void setDisable( boolean disable){
		this.disable= disable;
	}
	//获取道具
	public Magic getMagic(){
		return this.magic;
	}
	//设置道具
	public void setMagic(Magic magic){
		this.magic= magic;
	}
}
