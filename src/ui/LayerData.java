package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import dto.Player;

public abstract class LayerData extends Layer {

	// TODO 配置文件
	private static final int MAX_ROW = 5;

	private static final int EXP_H = IMG_EXP_H + 4;

	/**
	 * 起始Y坐标
	 */
	private static int START_Y;
	/**
	 * 间距
	 */
	private static int SPA = 0;

	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - (EXP_H) * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
		START_Y = +PADDING + Img.DB.getHeight(null) + SPA;
	}


	/**
	 * 绘制该窗口所有值槽
	 * @param imgTitle   标题图片 
	 * @param players    数据源
	 * @param g          画笔
	 */
	public void showData(Image imgTitle, List<Player> players, Graphics g) {
		// 绘制数据库标题
		g.drawImage(imgTitle, this.x + PADDING, this.y + PADDING, null);
		
		int point = this.dto.getNowPoint();
		for (int i = 0; i < MAX_ROW; i++) {
			Player player = players.get(i);
			double percent = (double) point / player.getPoint();
			percent = percent > 1 ? 1.0 : percent;
			this.drawRect(START_Y + (EXP_H + SPA) * i, player.getName(), player.getPoint(), percent, g);
		}
	}
	
	@Override
	public void paint(Graphics g) {
	}
}
