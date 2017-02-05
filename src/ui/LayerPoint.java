package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer{

	/**
	 * 分数最大位数
	 */
	private static final int POINT_BITS = 5;
	/**
	 * 分数标题图片
	 */
	private static Image IMG_POINT = new ImageIcon("Graphics/string/point.png").getImage();
	
	/**
	 * 消行标题图片
	 */
	private static Image IMG_RMLINE = new ImageIcon("Graphics/string/rmline.png").getImage();
	
	/**
	 * 分数Y坐标
	 */
	private final int pointY = PADDING;
	/**
	 * 消行Y坐标
	 */
	private final int rmLineY = pointY + IMG_POINT.getHeight(null) + PADDING;
	/**
	 * 经验值Y坐标
	 */
	private int expY = 0;
	/**
	 * 分数和消行共同X坐标
	 */
	private  int bothX = 0;
	/**
	 * 经验槽宽度
	 */
	private final int expW;
	
	private static final int LEVEL_UP = 30;
	
	
	public LayerPoint(int x,int y,int w,int h){
		super(x,y,w,h);
		// 初始化共同X坐标
		bothX = this.w - IMG_NUMBER_W * POINT_BITS - PADDING;
		// 初始化经验值Y坐标
		this.expY = rmLineY + IMG_RMLINE.getHeight(null) + PADDING;
		this.expW = this.y - (PADDING << 1 );
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		// 窗口标题(分数)
		g.drawImage(IMG_POINT, this.x + PADDING, this.y + pointY,null);
		// 绘制分数数字
		drawNumberLeftPadding(bothX,pointY,this.dto.getNowPoint(),POINT_BITS,g);
		// 窗口标题(消行)
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + rmLineY,null);
		// 绘制当前消行数字
		this.drawNumberLeftPadding(bothX,rmLineY,this.dto.getNowRemoveLine(),POINT_BITS,g);
		//绘制经验值值槽
		int h = 32;
		g.setColor(Color.BLACK);
		g.fillRect(this.x + PADDING, this.y + expY, this.expW, h);
		g.setColor(Color.WHITE);
		g.fillRect(this.x + PADDING + 1, this.y + expY + 1 , this.expW - 2, h - 2);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(this.x + PADDING + 2, this.y + expY + 2 , this.expW - 4, h - 4);
		g.setColor(Color.PINK);
		int w = (int)((double)this.expW - 4) / LEVEL_UP * (this.dto.getNowRemoveLine() % LEVEL_UP);
		g.fillRect(this.x + PADDING + 2, this.y + expY + 2 , w, h - 4);
	}
}
