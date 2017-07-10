package cn.jiangbo.util;

import cn.jiangbo.exception.GameException;
import cn.jiangbo.object.Piece;
import cn.jiangbo.object.Square;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by jiangbo on 2017/7/3.
 *
 */
public class ImageUtil {
    public static BufferedImage getImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            //读取图片异常，抛出GameException
            throw new GameException("read image error");
        }
    }

    /**
     * 在界面上画一个piece对象
     */
    public static void paintPiece(Graphics g, Piece piece) {
        if (piece == null) return;
        for (int i = 0;i<piece.getSquares().size();i++) {
            Square s = piece.getSquares().get(i);
            g.drawImage(s.getImage(), s.getBeginX(), s.getBeginY(), null);
        }
    }
}
