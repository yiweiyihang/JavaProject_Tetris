package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	
	/**
	 * 方块图案
	 */
	private static final Image[] BLOCKS_NEXT;
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

	public LayerNext(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		int typeCode = this.dto.getNext(); 
		Image blockImg = BLOCKS_NEXT[typeCode];
		drawAtCenter(blockImg,g);
		
		
	}
	
	
	/**
	 * 正中绘图
	 */
	private void drawAtCenter(Image img,Graphics g){
		int ImgW = img.getWidth(null);
		int ImgH = img.getHeight(null);
		int ImgX = this.x + (this.w - ImgW >> 1);
		int ImgY = this.y + (this.h - ImgH >> 1);
		g.drawImage(img,ImgX , ImgY , null);
	}

}
