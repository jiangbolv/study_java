package cn.jiangbo.viewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import cn.jiangbo.viewer.action.Action;

/*
 * 工具栏的Action类
 */
public class ViewerAction  extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionName = "";
	private ViewerFrame frame = null;
	//这个工具栏的AbstractAction所对应的cn.jiangbo.viewer.action包下的某个Action安全
	private Action action = null;
	
	/*
	 * 构造器
	 */
	public ViewerAction(){
		//调用父类构造器
		super();
	}
	public ViewerAction(ImageIcon icon,String actionName,ViewerFrame frame){
		super("",icon);
		this.actionName=actionName;
		this.frame= frame;
	}
	//重写actionPerformed(ActionEvent e)方法
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewerService service = ViewerService.getInstance();
		Action action= getAction(this.actionName);
		// 调用action的execute方法
		action.execute(service, frame);
		
	}
	private Action getAction(String actionName){
		try {
			if(this.action==null){
				Action action = (Action)Class.forName(actionName).newInstance();
				this.action=action;
			}
			return this.action;
		} catch (Exception e) {
			return null;
		} 
	}
}
