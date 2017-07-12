package cn.jiangbo;

import cn.jiangbo.tool.AbstractTool;
import cn.jiangbo.tool.Tool;
import cn.jiangbo.tool.ToolFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public class ImageAction extends AbstractAction {
    private String name = "";
    private ImageFrame frame= null;
    private Color color =null;
    private Tool tool = null;
    private JPanel colorPanel=null;

    //构造器
    public ImageAction(Color color, JPanel colorPanel) {
        //调用父构造器
        super();
        this.color=color;
        this.colorPanel=colorPanel;
    }

    public ImageAction(ImageIcon icon, String name, ImageFrame frame) {
        //调用父构造器
        super("", icon);
        this.name=name;
        this.frame=frame;
    }
    public void actionPerformed(ActionEvent e){
        //设置tool
     tool = name != "" ? ToolFactory.getToolInstance(frame,name):tool;
        if (tool != null) {
            frame.setTool(tool);
        }
        if (color != null) {
            //设置正在使用的颜色
            AbstractTool.color= color;
            colorPanel.setBackground(color);
        }
    }

}
