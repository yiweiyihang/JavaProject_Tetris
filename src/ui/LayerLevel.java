package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer{

	/**
	 * 标题图片
	 */
	private static final Image IMG_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();
	
	public LayerLevel(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		int centerX = this.w - IMG_LEVEL.getWidth(null) >> 1;
		//窗口标题
		g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING,null);
		//等级数字
		this.drawNumberLeftPadding(centerX,60,this.dto.getnowLevel(),2,g);
	}

}
