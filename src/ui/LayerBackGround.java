package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackGround extends Layer {
	
	private static Image IMG_BG_TEMP= new ImageIcon("Graphics/background/bg03.jpeg").getImage();
	public LayerBackGround(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		g.drawImage(IMG_BG_TEMP, 0, 0,1162,654, null);
		g.drawImage(IMG_BG_TEMP, x, y,w,h, null);
	}

}
