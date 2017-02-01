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
	 * @param panelGame  游戏Panel
	 */
	public GameControler(JPanelGame panelGame) {
		// TODO Auto-generated constructor stub
		this.panelGame = panelGame;
	}
	 

}
