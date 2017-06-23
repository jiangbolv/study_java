package cn.jiangbo.viewer;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/*
 * 图片浏览器业务
 */
public class ViewerService {
	private static ViewerService service = null;
	//新建一个ViewerFileChooser
	private ViewerFileChooser fileChooser = new ViewerFileChooser();
	//放大或缩小的比例
	private double range = 0.2;
	//目前的文件夹
	private File currentDirectory = null;
	//目前文件夹下的所有图片文件
	private List<File> currentFiles = null;
	//目前的图片文件
	private File currentFile = null;
	
	//私有构造器
	private ViewerService(){
		
	}
	
	//获取单态实例
	public static ViewerService getInstance(){
		if(service==null){
			service = new ViewerService();
		}
		return service;
	};
	
	//打开图片
	public void open(ViewerFrame frame){
		//如果选择打开
		if(fileChooser.showOpenDialog(frame)==ViewerFileChooser.APPROVE_OPTION){
			//给目前打开的文件赋值
			this.currentFile = fileChooser.getSelectedFile();
			//获取文件路径
			String name = this.currentFile.getPath();
			//获取目前文件夹
			File cd = fileChooser.getCurrentDirectory();
			//如果文件夹有变动
			if(cd !=this.currentDirectory|| this.currentDirectory==null){
				//或者fileChooser的所有FileFilter
				FileFilter[] fileFilters=fileChooser.getChoosableFileFilters();
				File files[] = cd.listFiles();
				this.currentFiles= new ArrayList<File>();
				for(File file:files){
					for(FileFilter filter:fileFilters){
						if(filter.accept(file)){
							this.currentFiles.add(file);
						}
					}
				}
			}
			ImageIcon icon = new ImageIcon(name);
			frame.getLabel().setIcon(icon);
		}
	}
	//放大放小
	public void zoom(ViewerFrame frame,boolean isEnlarge){
		//获取放大或者放小的乘比
		double enLargeRange = isEnlarge? 1+range:1-range;
		
		ImageIcon icon = (ImageIcon) frame.getLabel().getIcon();
		if(icon!=null){
			int width = (int) (icon.getIconWidth()*enLargeRange);
			ImageIcon newIcon = new ImageIcon(icon.getImage().getScaledInstance(width, -1, Image.SCALE_DEFAULT));
			//改变显示的图片
			frame.getLabel().setIcon(newIcon);
		}
	}
//上一个
	public void last(ViewerFrame frame){
		//如果有打开包含图片的文件夹
		if(this.currentFiles!=null&& !this.currentFiles.isEmpty()){
			int index = this.currentFiles.indexOf(this.currentFile);
			//打开上一个
			if(index>0){
				File file = (File) this.currentFiles.get(index-1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile=file;
			}
		}
	}
	//下一个
	public void next(ViewerFrame frame){
		//如果有打开包含图片的文件夹
		if(this.currentFiles!=null&&!this.currentFiles.isEmpty()){
			int index = this.currentFiles.indexOf(this.currentFile)+1;//此处有问题，有没有+1，随后要进行验证
			//打开下一个
			if(index +1<this.currentFiles.size()){
				File file = (File) this.currentFiles.get(index+1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile=file;
				
			}
		}
	}
	//相应菜单的动作
	public void menuDo(ViewerFrame frame,String cmd){
		//打开
		if(cmd.equals("打开(O)")){
			open(frame);
		}
		//放大
		if(cmd.equals("放大(M)")){
			zoom(frame,true);
		}
		// 缩小
				if (cmd.equals("缩小(O)")) {
					zoom(frame, false);
				}
				// 上一个
				if (cmd.equals("上一个(L)")) {
					last(frame);
				}
				// 下一个
				if (cmd.equals("下一个(P)")) {
					next(frame);
				}
				// 退出
				if (cmd.equals("退出(E)")) {
					System.exit(0);
				}
				// 帮助主题
				if(cmd.equals(("帮助主题"))){
					JOptionPane.showMessageDialog(null, 
							"如果需要帮助，请联系我：jiangbolv"+"\n"+"xingshenyuyan@gmail.com");
				}
				//关于
				if(cmd.equals("关于")){
					JOptionPane.showMessageDialog(null, "我是一个JAVA初学者"+"\n"+"这是第一版，做的计较简陋，还请多多指教");
				}
						
	}
}
