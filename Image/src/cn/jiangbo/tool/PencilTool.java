package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class PencilTool extends AbstractTool {
    private static Tool tool =null;
    private PencilTool(ImageFrame frame) {
        super(frame, "img/pencilcursor.gif");
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new PencilTool(frame);
        }
        return tool;
    }
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        // 获取图片的Graphics对象
        Graphics g = getFrame().getBufferedImage().getGraphics();
        if (getPressX() > 0 && getPressY() > 0) {
            g.setColor(AbstractTool.color);
            g.drawLine(getPressX(), getPressY(), e.getX(), e.getY());
            setPressX(e.getX());
            setPressY(e.getY());
            getFrame().getDrawSpace().repaint();
        }
    }
}
