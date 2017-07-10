package cn.jiangbo.object;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jiangbo on 2017/6/30.
 *
 * @author jiangbo
 *         一个块对象，一个块包含多个方块
 */
public class Piece {
    //该大方块里所包含的小方块
    private List<Square> squares;
    //该大方块的变化
    protected List<List<Square>> changes = new ArrayList<List<Square>>();

    protected Random random = new Random();
    //当前变化的索引（在changes集合中的索引）
    protected int currentIndex;
    //每个方块的边长
    public final static int SQUARE_BORDER = 16;

    public List<Square> getSquares()

    {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Square> getDefault() {
        //从changes集合中随机得到其中一种变化
        int defaultChange = random.nextInt(changes.size());
        //设置当前变化的索引
        this.currentIndex = defaultChange;
        return changes.get(defaultChange);
    }

    public void change() {
        if (this.changes.size() == 0) return;
        this.currentIndex+=1;
        //如果当前变化超过changes集合大小，则从0开始变化
        if(this.currentIndex>=changes.size()) this.currentIndex=0;
        this.squares = this.changes.get(this.currentIndex);

    }

    //让Piece对象中的所有Square对象的X坐标都加上参数x
    public void setSquareXLocation(int x) {
        for (int i=0;i<this.changes.size();i++) {
            List<Square> change = this.changes.get(i);
            for(int j= 0;j<change.size();j++){
                Square s = change.get(j);
                s.setBeginX(s.getBeginX() + x);
            }
        }
    }
    //让piece中所有square对象的y坐标都加上参数y
    public void setSquaresYLocation(int y){
        for(int i=0;i<this.changes.size();i++) {
            List<Square> change = this.changes.get(i);
            for (int j=0;j<change.size();j++) {
                Square s = change.get(j);
                s.setBeginY(s.getBeginY() + y);
            }
        }
    }

    //得到当前变化中x坐标最大的值
    public int getMaxXLocation() {
        int result = 0;
        for (int i= 0;i<this.squares.size();i++) {
            Square s = this.squares.get(i);
            if(s.getBeginX()>result) result = s.getBeginX();
        }
        return result+SQUARE_BORDER;
    }

    //得到当前变化中x坐标的最小值
    public int getMinXLocation() {
        int result = Integer.MAX_VALUE;
        for(int i=0;i<this.squares.size();i++) {
            Square s = this.squares.get(i);
            if (s.getBeginX() < result)  result = s.getBeginX();
        }return result;
    }

    //得到当前变化中Y坐标的最大值
    public int getMaxYLocation() {
        int result = 0;
        for (int i = 0; i < this.squares.size(); i++) {
            Square s = this.squares.get(i);
            if (s.getBeginY() > result) result=s.getBeginY();
        }
        return result+SQUARE_BORDER*2;
    }

    //得到当前变化的最小值
    public int getMinYLocation() {
        int result = Integer.MAX_VALUE;
        for(int i = 0;i<this.squares.size();i++) {
            Square s = this.squares.get(i);
            if(s.getBeginY()<result) result = s.getBeginY();
        }
        return result+SQUARE_BORDER;
    }
}
