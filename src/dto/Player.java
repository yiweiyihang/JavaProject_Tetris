package dto;

public class Player {
	
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 用户得分
	 */
	private int point;
	
	/**
	 *构造函数 
	 */
	public Player(String name, int point) {
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
