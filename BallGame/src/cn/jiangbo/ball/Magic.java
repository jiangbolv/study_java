package cn.jiangbo.ball;

import java.io.IOException;

public  abstract class Magic extends BallComponent{
	/*
	 * 提供给子类调用的构造器
	 */
	public Magic(String path,int x,int y) throws IOException{
		super(path,x,y);
	}
	//道具的功能
	public abstract void magicDo(Stick stick);
}
