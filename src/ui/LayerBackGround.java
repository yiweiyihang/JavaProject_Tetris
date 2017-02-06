package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackGround extends Layer {
	
	public LayerBackGround(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		g.drawImage(IMG_BG_TEMP, 0, 0,1162,654, null);
		g.drawImage(Img.BG_TEMP, x, y,w,h, null);
	}

}
