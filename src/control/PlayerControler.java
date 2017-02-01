package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControler extends KeyAdapter{

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

	

	/**
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.gameControler.test();
		System.out.println(e.getKeyCode());
		
	}

	
	

}
