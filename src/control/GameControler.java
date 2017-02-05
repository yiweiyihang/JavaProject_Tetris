package control;

import service.GameService;
import ui.JPanelGame;
/**
 * 接受玩家键盘事件
 * 控制画面
 * 控制游戏逻辑
 * @author 32618
 *
 */
public class GameControler {
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;

	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	/**
	 * 构造函数
	 * @param panelGame
	 * @param gameService
	 */
	public GameControler(JPanelGame panelGame,GameService gameService) {
		// TODO Auto-generated constructor stub
		this.panelGame = panelGame;
		this.gameService = gameService;
	}
	
	
	
	public void test() {
		// TODO Auto-generated method stub
		
	}



	/**
	 * 按键向上
	 */
	public void keyUp() {
		// TODO Auto-generated method stub
		this.gameService.keyUp();
		this.panelGame.repaint();
		
	}


 
	/**
	 * 按键向下
	 */
	public void keyDown() {
		// TODO Auto-generated method stub
		this.gameService.keyDown();
		this.panelGame.repaint();
	}


	/**
	 * 按键向左
	 */

	public void keyLeft() {
		// TODO Auto-generated method stub
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}


	/**
	 * 按键向右
	 */
	public void keyRight() {
		// TODO Auto-generated method stub
		this.gameService.keyRight();
		this.panelGame.repaint();
	}


    // TODO ======================测试专用 ==========================
	public void testLevelUp() {
		// TODO Auto-generated method stub
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}
	 

}
