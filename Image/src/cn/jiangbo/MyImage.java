package cn.jiangbo;

import java.awt.image.BufferedImage;

/**
 * 这个主要是用来
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/11.
 */
public class MyImage extends BufferedImage {
    //是否已经保存
    private boolean isSaved=true;

    public MyImage(int width, int height, int type) {
        super(width, height, type);
        this.getGraphics().fillRect(0, 0, width, height);
    }

    //设置是否保存
    public void setIsSaved(boolean b) {
        this.isSaved = b;
    }
    //是否已经保存
    public boolean isSaved() {
        return this.isSaved;
    }
}
