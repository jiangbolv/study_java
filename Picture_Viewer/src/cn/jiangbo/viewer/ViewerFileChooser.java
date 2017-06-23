package cn.jiangbo.viewer;
/*
 * 文件对话框对象
 */

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ViewerFileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;
	//使用用户默认路径创造一个ImageFileChooser
	public ViewerFileChooser(){
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}
	/*
	 * 使用自定义路径创建一个ViewerFileChooser
	 */
  public ViewerFileChooser(String currentDirectoryPath){
	  super(currentDirectoryPath);
	  setAcceptAllFileFilterUsed(false);
	  addFilter();
  }
  
  //增加文件过滤器
  	public void addFilter(){
  		this.addChoosableFileFilter(new MyFileFilter(new String[] {".BMP"},"BMP (*.BMP)") );
  		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",".JPEG", ".JPE", ".JFIF" },"JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },"GIF (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",".TIFF" }, "TIFF (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },"PNG (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },"ICO (*.ICO)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
		".PNG", ".ICO" }, "所有图形文件"));
  	}
  	class MyFileFilter extends FileFilter{
  		//后缀名数组
  		String[] suffarr;
  		//描述
  		String decription;
  		 
  		public MyFileFilter(){
  			super();
  		}
  	public MyFileFilter(String[] suffarr,String decriptin){
  		super();
  		this.suffarr= suffarr;
  		this.decription= decriptin;
  	}
  	//重写boolean accept(File f)方法
  	public boolean accept(File f){
  		for(String s: suffarr){
  			if(f.getName().toUpperCase().endsWith(s)){
  				return true;
  			}
  		}
  		//如果是目录，返回true，否则为false
  		return f.isDirectory();
  	}
  	//获取描述信息
  	public String getDescription(){
  		return this.decription;
  	}
  	}
}
