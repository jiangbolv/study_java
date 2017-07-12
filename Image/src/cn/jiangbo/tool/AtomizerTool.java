package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * 这个主要是用来喷墨工具
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class AtomizerTool extends AbstractTool{
    private static Tool tool = null;
    private AtomizerTool(ImageFrame frame) {
        super(frame, "img/atomizercursor.gif");
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new AtomizerTool(frame);
        }
        return tool;
    }
    //按下鼠标
    public void mousePressed(MouseEvent e) {
        if (e.getX() > 0 && e.getX() < AbstractTool.drawWidth && e.getY() > 0
                && e.getY() < AbstractTool.drawHeight) {
            setPressX(e.getX());
            setPressY(e.getY());
            Graphics g = getFrame().getBufferedImage().getGraphics();
            draw(e,g);
        }
    }
    //拖动鼠标
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Graphics g = getFrame().getBufferedImage().getGraphics();
        draw(e, g);
    }
    //画图
    public void draw(MouseEvent e, Graphics g) {
        int x = 0;
        int y = 0;
        // 喷枪大小
        int size = 8;
        // 喷枪点数
        int count = 10;
        if (getPressX() > 0 && getPressY() > 0
                && e.getX() < AbstractTool.drawWidth
                && e.getY() < AbstractTool.drawHeight) {
            g.setColor(AbstractTool.color);
            for (int i = 0; i < count; i++) {
                x = new Random().nextInt(size) + 1;
                y = new Random().nextInt(size) + 1;
                g.fillRect(e.getX() + x, e.getY() + y, 1, 1);
            }

            setPressX(e.getX());
            setPressY(e.getY());
            getFrame().getDrawSpace().repaint();
        }
    }



}
