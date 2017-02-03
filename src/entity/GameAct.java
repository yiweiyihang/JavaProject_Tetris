package entity;

import java.awt.Point;

public class GameAct {
	private Point[] actPoints;
	public GameAct(){
		actPoints = new Point[]{
				new Point(3,0),
				new Point(4,0),
				new Point(5,0),
				new Point(5,1)
		};
	}
	public Point[] getActPoint() {
		return actPoints;
	}
	public void setActPoints(Point[] actPoints) {
		this.actPoints = actPoints;
	}
	/**
	 * 移动方块
	 * @param moveX  X轴偏移量
	 * @param moveY  Y轴偏移量
	 */
	public void move(int moveX,int moveY){
		for(Point p : actPoints){
			p.x += moveX;
			p.y += moveY;
		}
	}
	

}
