package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayerDataBase extends LayerData {
	
	

	/**
	 * 构造函数
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public LayerDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	public void paint(Graphics g) {
		this.createWindow(g);

		this.showData(Img.DB, this.dto.getDbRecord(), g);
	}
}
