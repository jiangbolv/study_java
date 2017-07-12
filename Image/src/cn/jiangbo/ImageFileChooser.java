package cn.jiangbo;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public class ImageFileChooser extends JFileChooser {
    public ImageFileChooser() {
        super();
        setAcceptAllFileFilterUsed(false);
        addFilter();
    }

    //使用自定义路径创建一个ImageFilterChooser
    public ImageFileChooser(String currentDirectoryPath) {
        super(currentDirectoryPath);
        setAcceptAllFileFilterUsed(false);
        addFilter();
    }

    //获取后缀名
    public String getSuf() {
        //获取文件过滤对象
        FileFilter fileFilter = this.getFileFilter();
        String desc = fileFilter.getDescription();
        String[] sufarr = desc.split(" ");
        String suf = sufarr[0].equals("所有图形文件") ? "" : sufarr[0];
        return suf.toLowerCase();
    }

    //增加文件过滤器
    private void addFilter() {
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP" },
                "BMP (*.BMP)"));
        this
                .addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",
                        ".JPEG", ".JPE", ".JFIF" },
                        "JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },
                "GIF (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",
                ".TIFF" }, "TIFF (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },
                "PNG (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },
                "ICO (*.ICO)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",
                ".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
                ".PNG", ".ICO" }, "所有图形文件"));
    }

    class  MyFileFilter extends FileFilter {
        //后缀名数组
        String[] suffarr;
        //描述
        String decription;

        public MyFileFilter() {
            super();
        }

        public MyFileFilter(String[] suffarr, String decription) {
            super();
            this.suffarr=suffarr;
            this.decription = decription;
        }

        //判断文件是否合法
        public boolean accept(File f) {
        //如果文件后缀名合法，返回true
            for (String s : suffarr) {
                if (f.getName().toUpperCase().endsWith(s)) {
                    return true;
                }
            }
            //如果是目录
            return f.isDirectory();
        }

        //获取描述信息
        public String getDescription() {
            return this.decription;
        }


    }
}
