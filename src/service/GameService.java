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
		if(canMove(0, -1)){
			this.dto.getGameAct().move(0, -1);
		}
	}

	/**
	 * 按键向下
	 */
	public void keyDown() {
		// TODO
		if(canMove(0, 1)){
			this.dto.getGameAct().move(0, 1);
		}
	}

	/**
	 * 按键向左
	 */

	public void keyLeft() {
		// TODO Auto-generated method stub
		if(canMove(-1, 0)){
			this.dto.getGameAct().move(-1, 0);
		}
	}

	/**
	 * 按键向右
	 */
	public void keyRight() {
		// TODO Auto-generated method stub
		if(canMove(1, 0)){
			this.dto.getGameAct().move(1, 0);
		}
	}

	private boolean canMove(int moveX, int moveY) {
		Point[] nowLocation = this.dto.getGameAct().getActPoint();
		for (Point p : nowLocation) {
			int newX = p.x + moveX;
			int newY = p.y + moveY;
			if (newX < 0 || newX > 9 | newY<0 || newY>17)
				return false;
		}
		return true;
	}

}
