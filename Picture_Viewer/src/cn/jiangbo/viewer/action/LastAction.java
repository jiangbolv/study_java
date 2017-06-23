package cn.jiangbo.viewer.action;

import cn.jiangbo.viewer.ViewerFrame;
import cn.jiangbo.viewer.ViewerService;

public class LastAction implements Action{
    @Override 
	public void execute(ViewerService service, ViewerFrame frame) {
    	service.last(frame);
    };
}
