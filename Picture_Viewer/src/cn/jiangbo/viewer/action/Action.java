package cn.jiangbo.viewer.action;

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public interface Action {
	/*
	 * ����ִ�еķ���
	 */
	void execute(ViewerService service,ViewerFrame frame);
}
