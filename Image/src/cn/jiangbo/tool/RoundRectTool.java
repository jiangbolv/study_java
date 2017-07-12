package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

import java.awt.*;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class RoundRectTool extends AbstractTool {
    private static Tool tool = null;

    private RoundRectTool(ImageFrame frame) {
        super(frame);
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new RoundRectTool(frame);
        }
        return tool;
    }
    public void draw(Graphics g, int x1, int y1, int x2, int y2) {
        // 计算起点
        int x = x2 > x1 ? x1 : x2;
        int y = y2 > y1 ? y1 : y2;
        // 画圆矩形
        g.drawRoundRect(x, y, Math.abs(x1 - x2), Math.abs(y1 - y2), 20, 20);
    }
}
