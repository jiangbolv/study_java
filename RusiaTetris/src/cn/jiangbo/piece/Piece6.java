package cn.jiangbo.piece;

import cn.jiangbo.object.Piece;
import cn.jiangbo.object.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbo on 2017/7/3.
 */
public class Piece6 extends Piece {
    public Piece6(Image image) {
        //第一种变化
        List<Square> squares0 = new ArrayList<Square>();
        squares0.add(new Square(image, 0, image.getHeight(null)));
        squares0.add(new Square(image, image.getWidth(null), image.getHeight(null)));
        squares0.add(new Square(image, image.getWidth(null)*2, image.getHeight(null)));
        squares0.add(new Square(image, image.getWidth(null)*3, image.getHeight(null)));
        //第二种变化
        List<Square> squares1 = new ArrayList<Square>();
        squares1.add(new Square(image, image.getWidth(null), 0));
        squares1.add(new Square(image, image.getWidth(null), image.getHeight(null)));
        squares1.add(new Square(image, image.getWidth(null), image.getHeight(null)*2));
        squares1.add(new Square(image, image.getWidth(null), image.getHeight(null)*3));
        super.changes.add(squares0);
        super.changes.add(squares1);
        super.setSquares(getDefault());
    }
}
