package ui;

import java.awt.Graphics;

public class LayerAbout extends Layer{

	public LayerAbout(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		g.drawImage(Img.SIGN, this.x, this.y - 32, 
				this.x + Img.SIGN_W, this.y + Img.SIGN_H - 32 , 
				0, 0, Img.SIGN_W, Img.SIGN_H, null);
	} 
}
