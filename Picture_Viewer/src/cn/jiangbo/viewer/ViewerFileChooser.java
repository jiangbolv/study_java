package cn.jiangbo.viewer;
/*
 * �ļ��Ի������
 */

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ViewerFileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;
	//ʹ���û�Ĭ��·������һ��ImageFileChooser
	public ViewerFileChooser(){
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}
	/*
	 * ʹ���Զ���·������һ��ViewerFileChooser
	 */
  public ViewerFileChooser(String currentDirectoryPath){
	  super(currentDirectoryPath);
	  setAcceptAllFileFilterUsed(false);
	  addFilter();
  }
  
  //�����ļ�������
  	public void addFilter(){
  		this.addChoosableFileFilter(new MyFileFilter(new String[] {".BMP"},"BMP (*.BMP)") );
  		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",".JPEG", ".JPE", ".JFIF" },"JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },"GIF (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",".TIFF" }, "TIFF (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },"PNG (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },"ICO (*.ICO)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
		".PNG", ".ICO" }, "����ͼ���ļ�"));
  	}
  	class MyFileFilter extends FileFilter{
  		//��׺������
  		String[] suffarr;
  		//����
  		String decription;
  		 
  		public MyFileFilter(){
  			super();
  		}
  	public MyFileFilter(String[] suffarr,String decriptin){
  		super();
  		this.suffarr= suffarr;
  		this.decription= decriptin;
  	}
  	//��дboolean accept(File f)����
  	public boolean accept(File f){
  		for(String s: suffarr){
  			if(f.getName().toUpperCase().endsWith(s)){
  				return true;
  			}
  		}
  		//�����Ŀ¼������true������Ϊfalse
  		return f.isDirectory();
  	}
  	//��ȡ������Ϣ
  	public String getDescription(){
  		return this.decription;
  	}
  	}
}
