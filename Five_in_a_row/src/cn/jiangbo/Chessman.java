package cn.jiangbo;
/*
 * 棋子枚举类
 * @author jiangbo lvjiangbo0329@163.com
 */

public enum Chessman {
	BLACK("●"),WHITE("O");
	private String chessman;
	/*
	 * 私有构造器
	 */
	private Chessman(String chessman){
		this.chessman=chessman;
	}
	/*
	 * @return String 黑棋或者白棋
	 */
	public String getChessman(){
		return this.chessman;
	}
}
