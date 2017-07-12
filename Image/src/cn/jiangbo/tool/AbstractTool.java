package cn.jiangbo.tool;

import cn.jiangbo.ImageFrame;
import cn.jiangbo.ImageService;
import cn.jiangbo.MyImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public abstract class AbstractTool implements Tool {
    private ImageFrame frame = null;
    //定义画板的宽度
    public static int drawWidth = 0;
    //定义画板的高度
    public static int drawHeight = 0;
    //定义鼠标的默认指针
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    //按下鼠标的X坐标
    private int pressX= -1;
    //按下鼠标的Y坐标
    private int pressY = -1;
    //颜色
    public static Color color = Color.BLACK;

    //构造器
    public AbstractTool(ImageFrame frame) {
        this.frame=frame;
        AbstractTool.drawWidth = frame.getBufferedImage().getWidth();
        AbstractTool.drawHeight = frame.getBufferedImage().getHeight();
    }

    public AbstractTool(ImageFrame frame, String path) {
        this(frame);
        //创建工具鼠标图型
        this.defaultCursor = ImageService.createCursor(path);

    }

    //获取ImageFrame
    public ImageFrame getFrame() {
        return this.frame;
    }

    //获取默认鼠标指针
    public Cursor getDefaultCursor() {
        return this.defaultCursor;
    }

    //设置默认鼠标指针
    public void setDefaultCursor(Cursor cursor) {
        this.defaultCursor=cursor;
    }

    //设置 x,y坐标
    public void setPressX(int x) {
        this.pressX=x;
    }

    public void setPressY(int y) {
        this.pressY=y;
    }

    //获取x,y坐标
    public int getPressX() {
        return this.pressX;
    }

    public int getPressY() {
        return this.pressY;
    }

    //拖动鼠标
    public void mouseDragged(MouseEvent e) {
        //拖动图形边界
        dragBorder(e);
        //画图
        Graphics g = getFrame().getDrawSpace().getGraphics();
        createShape(e, g);
    }
    private  void dragBorder(MouseEvent e) {
        getFrame().getBufferedImage().setIsSaved(false);
        int cursorType = getFrame().getDrawSpace().getCursor().getType();
        int x = cursorType == Cursor.S_RESIZE_CURSOR ? AbstractTool.drawWidth
                : e.getX();
        int y = cursorType == Cursor.W_RESIZE_CURSOR ? AbstractTool.drawHeight
                : e.getY();
        MyImage img = null;
        // 如果鼠标指针是拖动状态
        if ((cursorType == Cursor.NW_RESIZE_CURSOR
                || cursorType == Cursor.W_RESIZE_CURSOR || cursorType == Cursor.S_RESIZE_CURSOR)
                && (x > 0 && y > 0)) {
            // getFrame().getDrawSpace().setSize( x + 4, y + 4 );
            // 改变图像大小
            img = new MyImage(x, y, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.setColor(Color.WHITE);
            g.drawImage(getFrame().getBufferedImage(), 0, 0,
                    AbstractTool.drawWidth, AbstractTool.drawHeight, null);
            getFrame().setBufferedImage(img);
            // 设置画布的大小
            AbstractTool.drawWidth = x;
            AbstractTool.drawHeight = y;
            // 设置viewport
            ImageService.setViewport(frame.getScroll(), frame.getDrawSpace(),
                    x, y);
        }

    }
    //移动鼠标
    public void mouseMoved(MouseEvent e) {
        //获取现在的鼠标的X与Y坐标
        int x = e.getX();
        int y = e.getY();
        //获取默认的鼠标指针
        Cursor cursor = getDefaultCursor();
        //如果鼠标在右下角
        if (x > AbstractTool.drawWidth - 4 && x < AbstractTool.drawWidth + 4
                && y > AbstractTool.drawHeight - 4
                && y < AbstractTool.drawHeight + 4) {
            // 将鼠标指针改变为右下拖动形状
            cursor = new Cursor(Cursor.NW_RESIZE_CURSOR);
        }
        // 如果鼠标指针在右中
        if (x > AbstractTool.drawWidth - 4 && x < AbstractTool.drawWidth + 4
                && y > (int) AbstractTool.drawHeight / 2 - 4
                && y < (int) AbstractTool.drawHeight / 2 + 4) {
            // 将鼠标指针改变为右拖动形状
            cursor = new Cursor(Cursor.W_RESIZE_CURSOR);
        }
        // 如果鼠标指针在下中
        if (y > AbstractTool.drawHeight - 4 && y < AbstractTool.drawHeight + 4
                && x > (int) AbstractTool.drawWidth / 2 - 4
                && x < (int) AbstractTool.drawWidth / 2 + 4) {
            // 将鼠标指针改变为下拖动形状
            cursor = new Cursor(Cursor.S_RESIZE_CURSOR);
        }
        // 设置鼠标指针类型
        getFrame().getDrawSpace().setCursor(cursor);

    }
    //松开鼠标
    public void mouseReleased(MouseEvent e) {
        //画图
        Graphics g = getFrame().getBufferedImage().getGraphics();
        createShape(e,g);
        //把pressX与pressY设置为初始值
        setPressX(-1);
        setPressY(-1);
        //重绘
        getFrame().getDrawSpace().repaint();
    }

    //画图形
    private void createShape(MouseEvent e, Graphics g) {
        //如果位置在画布内
        if (getPressX() > 0 && getPressY() > 0 && e.getX() > 0
                && e.getY() > 0 && e.getX() < AbstractTool.drawWidth && e.getY() < AbstractTool.drawHeight) {
            //将整张图片重画
            g.drawImage(getFrame().getBufferedImage(), 0, 0, AbstractTool.drawWidth, AbstractTool.drawHeight, null);
            //设置颜色
            g.setColor(AbstractTool.color);
            getFrame().getBufferedImage().setIsSaved(false);
            //画图形
            draw(g, getPressX(), getPressY(), e.getX(), e.getY());
        }
    }
    //按下鼠标
    public void mousePressed(MouseEvent e) {
        //如果位置在图片范围内，设置按下的坐标
            if (e.getX() > 0 && e.getX() < AbstractTool.drawWidth && e.getY() > 0
                    && e.getY() < AbstractTool.drawHeight) {
                setPressX(e.getX());
                setPressY(e.getY());
        }//
    }
    //点击鼠标
    public void mouseClicked(MouseEvent e) {

    }
    //画图像
    public void draw(Graphics g,int x1,int y1,int x2,int y2) {

    }

}
