package cn.jiangbo.viewer.action;
/*
 * �Ŵ�ͼƬ
 */

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public class BigAction implements Action{
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame,true);
	};
}
