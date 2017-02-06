package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Img {

	/**
	 * TODO 背景图片
	 */
	public static Image BG_TEMP= new ImageIcon("Graphics/background/bg03.jpeg").getImage();
	/**
	 * 签名图片
	 */
	public static final Image SIGN = new ImageIcon("Graphics/other/图片2.png").getImage();
	public static final int SIGN_W = SIGN.getWidth(null);
	public static final int SIGN_H = SIGN.getHeight(null);
	
	/**
	 * 等级标题图片
	 */
	public static final Image LEVEL = new ImageIcon("Graphics/string/level.png").getImage();
	/**
	 * 数据库标题图片
	 */
	public static final Image DB = new ImageIcon("Graphics/string/db.png").getImage();
	/**
	 * 本地磁盘标题图片
	 */
	public static final Image DISK= new ImageIcon("Graphics/string/disk.png").getImage();
	/**
	 * 正方块图片源
	 */
	public static final Image ACT = new ImageIcon("Graphics/game/rect.png").getImage(); 
	
	/**
	 * 方块图案
	 */
	public static final Image[] BLOCKS_NEXT;
	/**
	 *  TODO 方块最大种类数
	 */
	private static final int TYPE_MAX = 7;
	/**
	 * 静态初始化 将方块图案添加到数组中
	 */
	static{
		BLOCKS_NEXT = new Image[TYPE_MAX];
		for(int i=0; i<BLOCKS_NEXT.length; i++){
			BLOCKS_NEXT[i] = (new ImageIcon("Graphics/game/"+ i +".png").getImage());
		}
	}
	
	/**
	 * 分数标题图片
	 */
	public static final Image POINT = new ImageIcon("Graphics/string/point.png").getImage();
	
	/**
	 * 消行标题图片
	 */
	public static final Image RMLINE = new ImageIcon("Graphics/string/rmline.png").getImage();
}
