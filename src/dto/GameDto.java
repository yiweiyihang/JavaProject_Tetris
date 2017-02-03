package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	/**
	 * 数据库中用户记录
	 */
	private List<Player> dbRecord;
	/**
	 * 本地磁盘中用户记录
	 */
	private List<Player> diskRecord;
	/**
	 *主窗口方块状态
	 */
	private boolean[][] gameMap;
	/**
	 * 下落方块
	 */
	private GameAct gameAct;
	/**
	 * 下一个方块
	 */
	private int next;
	/**
	 * 用户等级
	 */
	private int nowLevel;
	/**
	 * 用户当前得分
	 */
	private int nowPoint;
	/**
	 * 已消除行数
	 */
	private int nowRemoveLine;
	
	/**
	 * 构造函数
	 */
	public GameDto(){
		dtoInit();
	}
	
	/**
	 * dto初始化
	 */
	public void dtoInit(){
		//TODO 硬编码
		this.gameMap = new boolean[10][18];
		// TODO 初始化所有dto 
	}
	
	
	/**
	 * get方法和set方法
	 * @return
	 */
	
	public List<Player> getDbRecord() {
		return dbRecord;
	}
	public void setDbRecord(List<Player> dbRecord) {
		this.dbRecord = dbRecord;
	}
	public List<Player> getDiskRecord() {
		return diskRecord;
	}
	public void setDiskRecord(List<Player> diskRecord) {
		this.diskRecord = diskRecord;
	}
	public boolean[][] getGameMap() {
		return gameMap;
	}
	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}
	public GameAct getGameAct() {
		return gameAct;
	}
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getnowLevel() {
		return nowLevel;
	}
	public void setnowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}
	public int getNowPoint() {
		return nowPoint;
	}
	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}
	public int getNowRemoveLine() {
		return nowRemoveLine;
	}
	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}



}
