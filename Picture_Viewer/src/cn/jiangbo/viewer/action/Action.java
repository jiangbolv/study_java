package cn.jiangbo.viewer.action;

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public interface Action {
	/*
	 * 具体执行的方法
	 */
	void execute(ViewerService service,ViewerFrame frame);
}
