package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * 这个主要是用来_橡皮擦
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class EraserTool extends AbstractTool {
    private static Tool tool = null;
    private EraserTool(ImageFrame frame) {
        super(frame, "img/erasercursor.gif");
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new EraserTool(frame);
        }
        return tool;
    }
    //拖动鼠标
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Graphics g = getFrame().getBufferedImage().getGraphics();
        int x = 0;
        int y = 0;
        // 橡皮擦
        int size = 4;
        if (getPressX() > 0 && getPressY() > 0) {
            g.setColor(Color.WHITE);
            x = e.getX() - getPressX() > 0 ? getPressX() : e.getX();
            y = e.getY() - getPressY() > 0 ? getPressY() : e.getY();
            g.fillRect(x - size, y - size, Math.abs(e.getX() - getPressX())
                    + size, Math.abs(e.getY() - getPressY()) + size);
            setPressX(e.getX());
            setPressY(e.getY());
            getFrame().getDrawSpace().repaint();
        }
    }

}
