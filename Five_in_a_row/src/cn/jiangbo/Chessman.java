package cn.jiangbo;
/*
 * ����ö����
 * @author jiangbo lvjiangbo0329@163.com
 */

public enum Chessman {
	BLACK("��"),WHITE("O");
	private String chessman;
	/*
	 * ˽�й�����
	 */
	private Chessman(String chessman){
		this.chessman=chessman;
	}
	/*
	 * @return String ������߰���
	 */
	public String getChessman(){
		return this.chessman;
	}
}
