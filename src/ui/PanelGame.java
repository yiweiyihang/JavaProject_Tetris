package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGame extends JPanel{

	public PanelGame(){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.fillRect(32,32, 32, 32);
	}
}
