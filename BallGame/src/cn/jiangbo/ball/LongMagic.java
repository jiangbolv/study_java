package cn.jiangbo.ball;

import java.io.IOException;

/*
 * 使挡板变长的道具类
 */
public class LongMagic extends Magic{
	//构造器
	public LongMagic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	//道具的功能，变长
	public void magicDo(Stick stick){
		double imageWidth = stick.getImage().getWidth(null);
		//如果挡板没有变长过
		if(stick.getPreWidth()<= imageWidth){
			//将挡板的长度改为双倍
			stick.setPreWidth((int)(stick.getPreWidth()*2));
		}
	}
}
