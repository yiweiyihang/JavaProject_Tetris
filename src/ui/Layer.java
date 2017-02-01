package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;

/*
 * 绘制窗口
 * @author yiweiyihangFT
 */
abstract public class Layer {
	
	
	//文字边距
	protected static final int PADDING;
	
	private static final int  SIZE;;
	//图片来源
	private static Image WINDOW_IMAGE = new ImageIcon("Graphics/windows/Window.png").getImage();
	//图片尺寸
	private static int WINDOW_W = WINDOW_IMAGE.getWidth(null);
	private static int WINDOW_H = WINDOW_IMAGE.getHeight(null);
	//图片坐标
	protected int x;
	protected int y;
	
	//windows尺寸
	protected int w;
	protected int h;
	
	static{
		//获取游戏配置
		GameConfig cfg = ConfigFactory.getGameConfig();
		PADDING = cfg.getPadding();
		SIZE = cfg.getWindowSize();
	}
	
	/*
	 * 构造函数
	 */
	public Layer(int x,int y,int w,int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	/**
	 * 绘制窗口方法
	 * @author yiweiyhangFT
	 * @param g  画笔
	 */
	protected  void createWindow(Graphics g){
		
		//g.drawImage(WINDOW_IMAGE, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		// 左上
				g.drawImage(WINDOW_IMAGE, x, y, (x + SIZE), (y + SIZE), 0, 0, SIZE, SIZE, null);
				// 中上
				g.drawImage(WINDOW_IMAGE, (x + SIZE), y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
				// 右上
				g.drawImage(WINDOW_IMAGE, (x + w - SIZE), y, (x + w), (y + SIZE), (WINDOW_W - SIZE), 0, WINDOW_W, SIZE, null);
				// 左中
				g.drawImage(WINDOW_IMAGE, x, (y + SIZE), (x + SIZE), (y + h - SIZE), 0, SIZE, SIZE, (WINDOW_H - SIZE), null);
				// 中央
				g.drawImage(WINDOW_IMAGE, (x + SIZE), (y + SIZE), (x + w - SIZE), (y + h - SIZE), SIZE, SIZE, (WINDOW_W - SIZE),
						(WINDOW_H - SIZE), null);
				// 右中
				g.drawImage(WINDOW_IMAGE, (x + w - SIZE), y + SIZE, (x + w), (y + h - SIZE), (WINDOW_W - SIZE), SIZE, WINDOW_W, WINDOW_H - SIZE,
						null);
				//左下
				g.drawImage(WINDOW_IMAGE, x,(y+h-SIZE), (x+SIZE), (y+h), 0, (WINDOW_H-SIZE), SIZE, WINDOW_H, null);
				//中下
				g.drawImage(WINDOW_IMAGE, (x+SIZE), (y+h-SIZE), (x+w-SIZE), (y+h), SIZE, (WINDOW_H-SIZE), (WINDOW_W-SIZE), WINDOW_H, null);
				//右下
				g.drawImage(WINDOW_IMAGE, (x+w-SIZE), (y+h-SIZE), (x+w), (y+h), (WINDOW_W-SIZE), (WINDOW_H-SIZE), WINDOW_W, WINDOW_H, null);
	}

	/**
	 * 刷新具体内容
	 * @author yiweiyihangFT
	 * @param g  画笔
	 */
	abstract public void paint(Graphics g);

}
