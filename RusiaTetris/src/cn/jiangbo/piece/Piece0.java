package cn.jiangbo.piece;

import cn.jiangbo.object.Piece;
import cn.jiangbo.object.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbo on 2017/6/30.
 * @author jiangbo
 * 各种小方块
 */
public class Piece0 extends Piece {
    public Piece0(Image image) {
        //创建各个小方块，一个集合为一种变化
        List<Square> squares = new ArrayList<Square>();
        squares.add(new Square(image, 0, 0));
        squares.add(new Square(image, 0, image.getHeight(null)));
        squares.add(new Square(image, image.getWidth(null), 0));
        squares.add(new Square(image, image.getWidth(null), image.getHeight(null)));
        //加入到变化中
        super.changes.add(squares);
        super.setSquares(squares);
    }
}
