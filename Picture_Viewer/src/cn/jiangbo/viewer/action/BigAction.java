package cn.jiangbo.viewer.action;
/*
 * ·Å´óÍ¼Æ¬
 */

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public class BigAction implements Action{
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame,true);
	};
}
