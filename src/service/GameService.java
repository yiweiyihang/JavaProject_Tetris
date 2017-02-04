package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {

	/**
	 * 游戏数据源
	 */
	private GameDto dto = new GameDto();
	
	/**
	 * 方块最大种类数
	 */
	private static final int TYPE_MAX = 7;
	
	/**
	 * 随机数生成器
	 */
	Random random = new Random();
	/**
	 * 构造函数
	 * @param gameDto
	 */
	public GameService(GameDto gameDto) {
		super();
		this.dto = gameDto;
		GameAct act = new GameAct(random.nextInt(TYPE_MAX ));
		dto.setGameAct(act);
	}

	/**
	 * 方块操作按键(向上)
	 */
	public void keyUp() {
		// TODO 旋转
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

	/**
	 * 方块操作按键(向下)
	 */
	public void keyDown() {
		// TODO

		// 判断方块是否能够向下移动  
		if(this.dto.getGameAct().move(0,1,this.dto.getGameMap())){
			// 能够向下移动 向下移动
			return;
		}
		
		//不能向下移动(到达底部)  
		//获得游戏地图对象
		boolean[][] map = this.dto.getGameMap();
		//获得方块对象
		Point[] act = this.dto.getGameAct().getActPoint();
		//将方块堆积到地图数组
		for(int i =0; i< act.length; i++){
			map[act[i].x][act[i].y] = true;
		}
		// TODO 判断是否可以消行
		// >>>>>>消行操作
		// >>>>>> 算分操作
		// >>>>>>判断是否升级
		// >>>>>>>>升级
		// TODO 刷新一个新的方块
		this.dto.getGameAct().init(random.nextInt(TYPE_MAX));
	}

	/**
	 * 方块操作按键(向左)
	 */

	public void keyLeft() {
		// TODO Auto-generated method stub
		this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

	/**
	 * 方块操作按键(向右)
	 */
	public void keyRight() {
		// TODO Auto-generated method stub
		this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}

}
