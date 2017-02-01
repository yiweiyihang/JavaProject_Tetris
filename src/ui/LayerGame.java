package ui;

import java.awt.Font;
import java.awt.Graphics;

public class LayerGame extends Layer {
	
	
	public LayerGame(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.setFont(new Font("黑体",Font.BOLD,64));
		String tempStr = Integer.toString(dto.getNowPoint());
		g.drawString(tempStr, x+PADDING, y+PADDING);
	}

}
