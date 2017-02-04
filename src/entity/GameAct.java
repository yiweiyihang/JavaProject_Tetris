package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	/**
	 * 方块数组
	 */
	private Point[] actPoints = null;
	
	/**
	 * 方块编号
	 */
	private int typeCode;

	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	private static final List<Point[]> ACT_TYPE_CONFIG;

	/**
	 * 静态初始化方块
	 */
	static {
		ACT_TYPE_CONFIG = new ArrayList<Point[]>(7);
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(3, 1) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(5, 0), new Point(3, 1), new Point(4, 1) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(5, 0), new Point(4, 1), new Point(5, 1) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1) });
		ACT_TYPE_CONFIG.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1) });
	}

	/**
	 * 构造函数
	 */
	public GameAct(int typeCode) {
		init(typeCode);
	}

	/**
	 * 初始化方块
	 * 
	 * @param i
	 */
	public void init(int typeCode) {
		// TODO 根据actCode的值刷新方块
		//初始化方块编号
		this.typeCode = typeCode;
		// 申请新的存储空间 复制数组   防止更改static对象
		Point[] points = ACT_TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for(int i=0; i<points.length; i++){
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
		
		

	}

	public int getTypeCode() {
		return typeCode;
	}

	public Point[] getActPoint() {
		return actPoints;
	}

	public void setActPoints(Point[] actPoints) {
		this.actPoints = actPoints;
	}

	/**
	 * 移动方块
	 * 
	 * @param moveX
	 *            X轴偏移量
	 * @param moveY
	 *            Y轴偏移量
	 */
	public boolean move(int moveX, int moveY, boolean[][] gameMap) {
		for (Point p : actPoints) {
			int newX = p.x + moveX;
			int newY = p.y + moveY;
			if (isOverZone(newX, newY, gameMap)) {
				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}

		return true;
	}

	/**
	 * 方块旋转 顺时针： A.x = O.y + O.x - B.y A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] gameMap) {
		// TODO 配置文件
		if(this.typeCode == 4){
			return;
		}
		for (int i = 1; i < actPoints.length; i++) {
			// 计算旋转坐标
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			// TODO 判断是否可以旋转
			if (isOverZone(newX, newY, gameMap)) {
				return;
			}
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}

	}

	/**
	 * 判断是否超出边界
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	//  
	private boolean isOverZone(int x, int y, boolean[][] gameMap) {
		return (x < MIN_X || x > MAX_X | y < MIN_Y || y > MAX_Y ||gameMap[x][y] == true );
	}

}
