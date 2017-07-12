package cn.jiangbo.tool;

import java.awt.event.MouseEvent;

/**
 * 这个主要是用来表示：所有工具的接口
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public interface Tool {
    //工具类型
    public static final String ARROW_TOOL = "ArrowTool";
    public static final String PENCIL_TOOL = "PencilTool";
    public static final String BRUSH_TOOL = "BrushTool";
    public static final String CUT_TOOL = "CutTool";
    public static final String ERASER_TOOL = "EraserTool";
    public static final String LINE_TOOL = "LineTool";
    public static final String RECT_TOOL = "RectTool";
    public static final String POLYGON_TOOL = "PolygonTool";
    public static final String ROUND_TOOL = "RoundTool";
    public static final String ROUNDRECT_TOOL = "RoundRectTool";
    public static final String ATOMIZER_TOOL = "AtomizerTool";
    public static final String COLORPICKED_TOOL = "ColorPickedTool";

    /**
     * 拖动鼠标
     */
    public void mouseDragged(MouseEvent e);
    //移动鼠标
    public void mouseMoved(MouseEvent e);
    //松开鼠标
    public void mouseReleased(MouseEvent e);
    //按下鼠标
    public void mousePressed(MouseEvent e);
    //点击鼠标
    public void mouseClicked(MouseEvent e);
}
