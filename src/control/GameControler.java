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
		gameService.gameTest();
		this.panelGame.repaint();
	}
	 

}
