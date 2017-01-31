package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * 绘制窗口
 * @author yiweiyihangFT
 */
public class Lay {
	
	private static final int  SIZE = 7;
	//图片来源
	private static Image WINDOW_IMAGE = new ImageIcon("Graphics/windows/Window.png").getImage();
	//图片尺寸
	private static int WINDOW_W = WINDOW_IMAGE.getWidth(null);
	private static int WINDOW_H = WINDOW_IMAGE.getHeight(null);
	//图片坐标
	private int x;
	private int y;
	
	//windows尺寸
	private int w;
	private int h;
	
	/*
	 * 构造函数
	 */
	public Lay(int x,int y,int w,int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	/*
	 * 绘制窗口方法
	 */
	public void createWindow(Graphics g){
		
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

}
