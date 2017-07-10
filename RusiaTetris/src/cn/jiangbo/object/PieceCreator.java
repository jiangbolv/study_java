package cn.jiangbo.object;

/**
 * Created by jiangbo on 2017/7/3.
 */
public interface PieceCreator {
    Piece createPiece(int x, int y);

    Piece getPiece();
}
