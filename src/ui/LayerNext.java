package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	
	

	public LayerNext(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		int typeCode = this.dto.getNext(); 
		Image blockImg = Img.BLOCKS_NEXT[typeCode];
		drawAtCenter(blockImg,g);
		
		
	}
	
	
	

}
