package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControler extends KeyAdapter {

	/**
	 * 游戏控制器
	 */
	private GameControler gameControler;

	/**
	 * 构造函数
	 * 
	 * @param gameControler
	 */
	public PlayerControler(GameControler gameControler) {
		// TODO Auto-generated constructor stub
		this.gameControler = gameControler;
	}

	/**
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 这样枚举不好
//		this.gameControler.test();
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				gameControler.keyUp();
				break;
			case KeyEvent.VK_DOWN:
				gameControler.keyDown();
				break;
			case KeyEvent.VK_LEFT:
				gameControler.keyLeft();
				break;
			case KeyEvent.VK_RIGHT:
				gameControler.keyRight();
				break;
			default:
				
		}
		
	}

}
