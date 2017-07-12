package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

import java.awt.*;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class LineTool extends AbstractTool {
    private static Tool tool = null;
    private LineTool(ImageFrame frame) {
        super(frame);
        // super.setShape( new LineShape() );
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new LineTool(frame);
        }
        return tool;
    }
    public void draw(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }
}
