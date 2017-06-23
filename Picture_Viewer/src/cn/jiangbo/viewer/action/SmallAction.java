package cn.jiangbo.viewer.action;

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public class SmallAction implements Action {
	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame,false);
	};
}
