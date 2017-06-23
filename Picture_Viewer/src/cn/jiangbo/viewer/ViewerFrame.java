package cn.jiangbo.viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

/* 
 * ���������
 * @author jiangbo lvjiangbo0329@163.com
 */

public class ViewerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���ö�ͼ���Ŀ�͸�
	private int width = 1024;
	private int height = 768;
	//��һ��JLabel����ͼƬ
	JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();
	//�Ӹ��˵����¼�������
	
	ActionListener menuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			service.menuDo(ViewerFrame.this,e.getActionCommand());
			
		}
	};
	//������
	public ViewerFrame(){
		super();
		//��ʼ�����JFrame
		init();
	}
	//��ʼ��
	public void init(){
		//���ñ���
		this.setTitle("ͼƬ�����");
		//���ô�С
		this.setPreferredSize(new Dimension(width, height));
		//�����˵�
		createMenuBar();
		//����������
		JPanel toolBar = createToolPanel();
		//�ѹ������Ͷ�ͼ���ŵ�JFrame����
		this.add(toolBar, BorderLayout.NORTH);
		this.add(new JScrollPane(label),BorderLayout.CENTER);
		//����Ϊ�ɼ�
		this.setVisible(true);
		this.pack();
	}
	/*
	 * ��ȡlabel
	 */
	public JLabel getLabel(){
		return this.label;
	}
	/*
	 * ����������
	 */
	public JPanel createToolPanel(){
		//����һ��JPanel
		JPanel panel = new JPanel();
		//����һ������Ϊ�����ߡ��Ĺ�����
		JToolBar toolBar = new JToolBar("����");
		//����Ϊ�����϶�
		toolBar.setFloatable(false);
		//���ò��ַ�ʽ
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//��������
		String[] toolarr = {
				"cn.jiangbo.viewer.action.OpenAction","cn.jiangbo.viewer.action.LastAction",
				"cn.jiangbo.viewer.action.NextAction","cn.jiangbo.viewer.action.BigAction",
				"cn.jiangbo.viewer.action.SmallAction"
		};
		for(int i=0;i < toolarr.length;i++){
			ViewerAction action = new ViewerAction(new ImageIcon("img/"+
		toolarr[i]+".gif"),toolarr[i],this);
			//��ͼ�괴��һ���µ�Button
			JButton  button = new JButton(action);
			toolBar.add(button);
		}
		panel.add(toolBar);
		return panel;
	}
	/*
	 * �����˵���
	 */
	public void createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		String[] menuArr = {
				"�ļ�(File)","����(Tool)","����(Help)"
		};
		//�˵���������
		String[][] menuItemArr = {
				{"��(O)","-","�˳�(E)"},{"�Ŵ�(M)","��С(O)","-","��һ��(L)","��һ��(P)"},{"��������","����"}
		};
		//����menuArr��menuItemArrȥ�����˵�
		for(int i= 0;i<menuArr.length;i++){
			//�½�һ��JMenu�˵�
			JMenu menu = new JMenu(menuArr[i]);
			for(int j=0;j< menuItemArr[i].length;j++){
				if(menuItemArr[i][j].equals("-")){
					//���ò˵�����
					menu.addSeparator();
				}else {
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(menuListener);
					
					menu.add(menuItem);
				}
			}
			menuBar.add(menu);
		}
		//����JMenubar
		this.setJMenuBar(menuBar);
	}
}
