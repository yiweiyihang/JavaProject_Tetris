package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer{

	private static Image IMG_POINT = new ImageIcon("Graphics/string/point.png").getImage();
	public LayerPoint(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_POINT, this.x + PADDING, this.y + PADDING,null);
	}
}
