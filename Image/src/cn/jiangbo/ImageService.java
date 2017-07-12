package cn.jiangbo;

import cn.jiangbo.tool.AbstractTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 这个主要是用来画图工具处理逻辑类
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public class ImageService {
    private ImageFileChooser fileChooser = new ImageFileChooser();

    //获取屏幕分辨率
    public Dimension getScreenSize() {
        Toolkit dt = Toolkit.getDefaultToolkit();
        return dt.getScreenSize();
    }

    //初始化新的drawSpace
    public void initDrawSpace(ImageFrame frame) {
        //获取画图对象
        Graphics g = frame.getBufferedImage().getGraphics();
        //获取画布的大小
        Dimension d = frame.getDrawSpace().getPreferredSize();
        //获取宽、高
        int drawWidth = (int) d.getWidth();
        int drawHeight = (int) d.getHeight();
        //绘画区
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, drawWidth, drawHeight);
    }
    //重画
    public void repaint(Graphics g, BufferedImage bufferedImage) {
        int drawWidth = bufferedImage.getWidth();
        int drawHeight = bufferedImage.getHeight();
        Dimension screenSize = getScreenSize();
        // 设置非绘画区的颜色
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, (int) screenSize.getWidth() * 10, (int) screenSize
                .getHeight() * 10);
        // 设置拖动点的颜色
        g.setColor(Color.BLUE);
        g.fillRect(drawWidth, drawHeight, 4, 4);
        g.fillRect(drawWidth, (int) drawHeight / 2 - 2, 4, 4);
        g.fillRect((int) drawWidth / 2 - 2, drawHeight, 4, 4);
        // 把缓冲的图片绘画出来
        g.drawImage(bufferedImage, 0, 0, drawWidth, drawHeight, null);
    }


    //创建鼠标图型
    public static Cursor createCursor(String path) {
        Image cursorImage = Toolkit.getDefaultToolkit().createImage(path);
        return Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,
                new Point(10,10),"mycursor");
    }
    //设置Jviewport
    public static void setViewport(JScrollPane scroll, JPanel panel, int width,
                                   int height) {
        // 新建一个JViewport
        JViewport viewport = new JViewport();
        // 设置viewport的大小
        panel.setPreferredSize(new Dimension(width + 50, height + 50));
        // 设置viewport
        viewport.setView(panel);
        scroll.setViewport(viewport);
    }
    //保存图片

    public void save(boolean b, ImageFrame frame) {
        if (b) {
            // 如果选择保存
            if (fileChooser.showSaveDialog(frame) == ImageFileChooser.APPROVE_OPTION) {
                // 获取当前路径
                File currentDirectory = fileChooser.getCurrentDirectory();
                // 获取文件名
                String fileName = fileChooser.getSelectedFile().getName();
                // 获取后缀名
                String suf = fileChooser.getSuf();
                // 组合保存路径
                String savePath = currentDirectory + "\\" + fileName + "."
                        + suf;
                try {
                    // 将图片写到保存路径
                    ImageIO.write(frame.getBufferedImage(), suf, new File(
                            savePath));
                } catch (java.io.IOException ie) {
                    ie.printStackTrace();
                }
                // 设置保存后的窗口标题
                frame.setTitle(fileName + "." + suf + " - 画图");
                // 已保存
                frame.getBufferedImage().setIsSaved(true);
            }
        } else if (!frame.getBufferedImage().isSaved()) {
            // 新建一个对话框
            JOptionPane option = new JOptionPane();
            // 显示确认保存对话框YES_NO_OPTION
            int checked = option.showConfirmDialog(frame, "保存改动?", "画图",
                    option.YES_NO_OPTION, option.WARNING_MESSAGE);
            // 如果选择是
            if (checked == option.YES_OPTION) {
                // 保存图片
                save(true, frame);
            }
        }
    }
    //打开图片
    public void open(ImageFrame frame) {
        save(false, frame);
        // 如果打开一个文件
        if (fileChooser.showOpenDialog(frame) == ImageFileChooser.APPROVE_OPTION) {
            // 获取选择的文件
            File file = fileChooser.getSelectedFile();
            // 设置当前文件夹
            fileChooser.setCurrentDirectory(file);
            BufferedImage image = null;
            try {
                // 从文件读取图片
                image = ImageIO.read(file);
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return;
            }
            // 宽，高
            int width = image.getWidth();
            int height = image.getHeight();
            AbstractTool.drawWidth = width;
            AbstractTool.drawHeight = height;
            // 创建一个MyImage
            MyImage myImage = new MyImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            // 把读取到的图片画到myImage上面
            myImage.getGraphics().drawImage(image, 0, 0, width, height, null);
            frame.setBufferedImage(myImage);
            // repaint
            frame.getDrawSpace().repaint();
            // 重新设置viewport
            ImageService.setViewport(frame.getScroll(), frame.getDrawSpace(),
                    width, height);
            // 设置保存后的窗口标题
            frame.setTitle(fileChooser.getSelectedFile().getName() + " - 画图");
        }
    }
    //创建新图片
    public void createGraphics(ImageFrame frame) {
        save(false, frame);
        // 宽，高
        int width = (int) getScreenSize().getWidth() / 2;
        int height = (int) getScreenSize().getHeight() / 2;
        AbstractTool.drawWidth = width;
        AbstractTool.drawHeight = height;
        // 创建一个MyImage
        MyImage myImage = new MyImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = myImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        frame.setBufferedImage(myImage);
        // repaint
        frame.getDrawSpace().repaint();
        // 重新设置viewport
        ImageService.setViewport(frame.getScroll(), frame.getDrawSpace(),
                width, height);
        // 设置保存后的窗口标题
        frame.setTitle("未命名 - 画图");
    }
    //编辑颜色
    public void editColor(ImageFrame frame) {
        // 获取颜色
        Color color = JColorChooser.showDialog(frame.getColorChooser(), "编辑颜色",
                Color.BLACK);
        color = color == null ? AbstractTool.color : color;
        // 设置工具的颜色
        AbstractTool.color = color;
        // 设置目前显示的颜色
        frame.getCurrentColorPanel().setBackground(color);
    }
    //退出
    public void exit(ImageFrame frame) {
        save(false, frame);
        System.exit(0);
    }
    //设置是否可见
    public void setVisible(JPanel panel) {
        boolean b = panel.isVisible() ? false : true;
        panel.setVisible(b);
    }
    //处理菜单事件
    public void menuDo(ImageFrame frame, String cmd) {
        if (cmd.equals("编辑颜色")) {
            editColor(frame);
        }

        if (cmd.equals("工具箱(T)")) {
            setVisible(frame.getToolPanel());
        }

        if (cmd.equals("颜料盒(C)")) {
            setVisible(frame.getColorPanel());
        }

        if (cmd.equals("新建(N)")) {
            createGraphics(frame);
        }

        if (cmd.equals("打开(O)")) {
            open(frame);
        }

        if (cmd.equals("保存(S)")) {
            save(true, frame);
        }

        if (cmd.equals("退出(X)")) {
            exit(frame);
        }
        // 帮助主题
        if(cmd.equals(("帮助主题"))){
            JOptionPane.showMessageDialog(null,
                    "如果需要帮助，请联系我：jiangbolv"+"\n"+"xingshenyuyan@gmail.com");
        }
        //关于
        if(cmd.equals("关于")){
            JOptionPane.showMessageDialog(null, "我是一个JAVA初学者"+"\n"+"这是第一版，做的计较简陋，还请多多指教");
        }

    }

}
