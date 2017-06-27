package cn.jiangbo.ball;

import java.io.IOException;

public class ShortMagic extends Magic{
	
	//构造器
	public ShortMagic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	public void magicDo(Stick stick){
		double imageWidth = stick.getImage().getWidth(null);
		if(stick.getPreWidth()>= imageWidth){
			//将挡板的宽度改为一半
			stick.setPreWidth((int) (stick.getPreWidth()*0.5));
		}
	}
}
