package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControler implements KeyListener{

	/**
	 * 游戏控制器
	 */
	private GameControler gameControler;
	/**
	 * 构造函数
	 * @param gameControler
	 */
	public PlayerControler(GameControler gameControler) {
		// TODO Auto-generated constructor stub
		this.gameControler = gameControler;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.print(e.getKeyCode()+",");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
