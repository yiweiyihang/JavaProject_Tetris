package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameGame extends JFrame {

	/*
	 * 构造函数
	 */
	public JFrameGame() {
		// 设置标题
		this.setTitle("Java俄罗斯方块");
		// 设置默认关闭操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO 设置大小
		this.setSize(1168, 680);
		// 不允许用户改变窗口大小
		this.setResizable(false);
		// 设置居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2 - 16;
		this.setLocation(x, y);
		//设置默认Panel
		this.setContentPane(new JPanelGame());
	}

}
