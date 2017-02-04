package ui;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {
	/**
	 * 方块图片源
	 */
	private static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage(); 
	// TODO 配置文件
	/**
	 * 左位移偏移量
	 */
	private static int ACT_SIZE_ROL = 5;
	
	/**
	 * 构造函数
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public LayerGame(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	
	public void paint(Graphics g){
		this.createWindow(g);
		//获得方块数组集合
		Point[] points = this.dto.getGameAct().getActPoint();
		//获得方块编号(0~6)
		int typeCode = this.dto.getGameAct().getTypeCode();
		//打印方块
		for(int i = 0;i < points.length;i++){
			//根据方块编号 计算偏移量 切图片
			drawActByPoint(points[i].x, points[i].y,typeCode,g);
			
		}
		
		// 打印地图(已放置的方块)
		boolean [][] map = this.dto.getGameMap();
		// TODO 获取当前等级
		int temp_level = -1;
		for(int x = 0; x < map.length; x++){
			for(int y=0; y < map[x].length; y++){
				if(map[x][y]){
					//绘制正方形
					drawActByPoint(x,y,temp_level,g);
				}
			}
		}
	}
	
	/**
	 * 绘制正方形
	 * @param x
	 * @param y
	 * @param imgIdx
	 * @param g
	 */
	private void drawActByPoint(int x, int y,int imgIdx,Graphics g){
		g.drawImage(ACT,
				this.x + (x << ACT_SIZE_ROL) + 7,
				this.y + (y << ACT_SIZE_ROL) + 7,
				this.x + (x + 1 << ACT_SIZE_ROL) + 7,
				this.y + (y + 1 << ACT_SIZE_ROL) + 7,
				imgIdx + 1 <<  ACT_SIZE_ROL,
				0,
			    imgIdx + 2 << ACT_SIZE_ROL,
				32,
				null); 
	}

}
