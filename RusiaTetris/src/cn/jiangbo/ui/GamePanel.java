package cn.jiangbo.ui;

import cn.jiangbo.object.Piece;
import cn.jiangbo.object.Square;
import cn.jiangbo.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 这个主要是用来游戏的画板
 *
 * @Author: jiangbo
 * Created by jiangbo on 2017/7/6.
 */
public class GamePanel extends JPanel{
    MainFrame mainFrame;
    private Image background = ImageUtil.getImage("images/background.jpg");

    public GamePanel(MainFrame mainFrame) {
        this.mainFrame= mainFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(this.background, 0, 0, this.getWidth(), this.getHeight(), null);
        Piece currentPiece = this.mainFrame.getCurrentPiece();
        ImageUtil.paintPiece(g, currentPiece);
        Square[][] squares = this.mainFrame.getSquares();
        if (squares == null) return;
        for(int i =0;i<squares.length;i++) {
            for (int j=0;j<squares[i].length;j++) {
                Square s = squares[i][j];
                if(s!=null){
                    g.drawImage(s.getImage(), s.getBeginX(), s.getBeginY(), this);
                }
            }
        }
    }
}
