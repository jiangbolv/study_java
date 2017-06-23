package cn.jiangbo.viewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import cn.jiangbo.viewer.action.Action;

/*
 * ��������Action��
 */
public class ViewerAction  extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionName = "";
	private ViewerFrame frame = null;
	//�����������AbstractAction����Ӧ��cn.jiangbo.viewer.action���µ�ĳ��Action��ȫ
	private Action action = null;
	
	/*
	 * ������
	 */
	public ViewerAction(){
		//���ø��๹����
		super();
	}
	public ViewerAction(ImageIcon icon,String actionName,ViewerFrame frame){
		super("",icon);
		this.actionName=actionName;
		this.frame= frame;
	}
	//��дactionPerformed(ActionEvent e)����
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ViewerService service = ViewerService.getInstance();
		Action action= getAction(this.actionName);
		// ����action��execute����
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
