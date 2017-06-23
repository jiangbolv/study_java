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
 * 主界面对象
 * @author jiangbo lvjiangbo0329@163.com
 */

public class ViewerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//设置读图区的宽和高
	private int width = 1024;
	private int height = 768;
	//用一个JLabel放置图片
	JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();
	//加给菜单的事件监听器
	
	ActionListener menuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			service.menuDo(ViewerFrame.this,e.getActionCommand());
			
		}
	};
	//构造器
	public ViewerFrame(){
		super();
		//初始化这个JFrame
		init();
	}
	//初始化
	public void init(){
		//设置标题
		this.setTitle("图片浏览器");
		//设置大小
		this.setPreferredSize(new Dimension(width, height));
		//创建菜单
		createMenuBar();
		//创建工具栏
		JPanel toolBar = createToolPanel();
		//把工具栏和读图区放到JFrame里面
		this.add(toolBar, BorderLayout.NORTH);
		this.add(new JScrollPane(label),BorderLayout.CENTER);
		//设置为可见
		this.setVisible(true);
		this.pack();
	}
	/*
	 * 获取label
	 */
	public JLabel getLabel(){
		return this.label;
	}
	/*
	 * 创建工具栏
	 */
	public JPanel createToolPanel(){
		//创建一个JPanel
		JPanel panel = new JPanel();
		//创建一个名称为“工具”的工具栏
		JToolBar toolBar = new JToolBar("工具");
		//设置为不可拖动
		toolBar.setFloatable(false);
		//设置布局方式
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//工具数组
		String[] toolarr = {
				"cn.jiangbo.viewer.action.OpenAction","cn.jiangbo.viewer.action.LastAction",
				"cn.jiangbo.viewer.action.NextAction","cn.jiangbo.viewer.action.BigAction",
				"cn.jiangbo.viewer.action.SmallAction"
		};
		for(int i=0;i < toolarr.length;i++){
			ViewerAction action = new ViewerAction(new ImageIcon("img/"+
		toolarr[i]+".gif"),toolarr[i],this);
			//以图标创建一个新的Button
			JButton  button = new JButton(action);
			toolBar.add(button);
		}
		panel.add(toolBar);
		return panel;
	}
	/*
	 * 创建菜单栏
	 */
	public void createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		String[] menuArr = {
				"文件(File)","工具(Tool)","帮助(Help)"
		};
		//菜单项文字组
		String[][] menuItemArr = {
				{"打开(O)","-","退出(E)"},{"放大(M)","缩小(O)","-","上一个(L)","下一个(P)"},{"帮助主题","关于"}
		};
		//遍历menuArr和menuItemArr去创建菜单
		for(int i= 0;i<menuArr.length;i++){
			//新建一个JMenu菜单
			JMenu menu = new JMenu(menuArr[i]);
			for(int j=0;j< menuItemArr[i].length;j++){
				if(menuItemArr[i][j].equals("-")){
					//设置菜单分离
					menu.addSeparator();
				}else {
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(menuListener);
					
					menu.add(menuItem);
				}
			}
			menuBar.add(menu);
		}
		//设置JMenubar
		this.setJMenuBar(menuBar);
	}
}
