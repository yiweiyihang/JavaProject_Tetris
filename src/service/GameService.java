package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {

	private GameDto dto = new GameDto();

	public GameService(GameDto gameDto) {
		super();
		this.dto = gameDto;
		GameAct act = new GameAct();
		dto.setGameAct(act);
	}

	/**
	 * 按键向上
	 */
	public void keyUp() {
		// TODO 旋转
		this.dto.getGameAct().round();
	}

	/**
	 * 按键向下
	 */
	public void keyDown() {
		// TODO

		// 方块到达底部时 放置方块
		if(!this.dto.getGameAct().move(0,1)){
			//获得游戏地图对象
			boolean[][] map = this.dto.getGameMap();
			Point[] act = this.dto.getGameAct().getActPoint();
			for(int i =0; i< act.length; i++){
				map[act[i].x][act[i].y] = true;
			}
			
		}
	}

	/**
	 * 按键向左
	 */

	public void keyLeft() {
		// TODO Auto-generated method stub
		this.dto.getGameAct().move(-1, 0);
	}

	/**
	 * 按键向右
	 */
	public void keyRight() {
		// TODO Auto-generated method stub
		this.dto.getGameAct().move(1, 0);
	}

}
