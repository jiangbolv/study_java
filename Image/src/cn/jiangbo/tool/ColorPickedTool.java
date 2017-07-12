package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/12.
 */
public class ColorPickedTool extends AbstractTool {
    private static Tool tool = null;
    private ColorPickedTool(ImageFrame frame) {
        super(frame, "img/colorcursor.gif");
    }

    public static Tool getInstance(ImageFrame frame) {
        if (tool == null) {
            tool = new ColorPickedTool(frame);
        }
        return tool;
    }
}
