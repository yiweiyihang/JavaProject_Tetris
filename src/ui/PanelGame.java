package ui;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelGame extends JPanel {
	
	private Lay lay1 = new Lay(40,32,334,279);
	private Lay lay2 = new Lay(40,343,334,279);
	private Lay lay3 = new Lay(414,32,334,590);
	
	private Lay[] lays = null;
	
	
	public PanelGame() {
		// 硬编码  不推荐
		lays = new Lay[]{
				new Lay(40,32,334,279),
				new Lay(40,343,334,279),
				new Lay(414,32,334,590),
				new Lay(788,32,334,124),
				new Lay(788,188,176,148),
				new Lay(964,188,158,148),
				new Lay(788,368,334,200)
				
		};

	}

	@Override
	public void paintComponent(Graphics g) {
		//循环刷新游戏画面
		for(Lay lay : lays){
			//刷新层窗口
			lay.createWindow(g);
		}
	}
}
