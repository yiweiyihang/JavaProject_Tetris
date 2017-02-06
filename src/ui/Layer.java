package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/*
 * 绘制窗口
 * @author yiweiyihangFT
 */
abstract public class Layer {
	
	
	/**
	 * 文字边距
	 */
	protected static final int PADDING;
	/**
	 * 边框尺寸
	 */
	private static final int  SIZE;;
	/**
	 * 窗口图片来源
	 */
	private static Image WINDOW_IMAGE = new ImageIcon("Graphics/windows/Window.png").getImage();
	/**
	 * 图片尺寸
	 */
	private static int WINDOW_W = WINDOW_IMAGE.getWidth(null);
	private static int WINDOW_H = WINDOW_IMAGE.getHeight(null);
	/**
	 * 窗口坐标
	 */
	protected int x;
	protected int y;
	
	/**
	 * 窗口尺寸
	 */
	protected int w;
	protected int h;
	/**
	 * 游戏数据源
	 */
	protected GameDto dto = null;
	static{
		//获取游戏配置
		GameConfig cfg = ConfigFactory.getGameConfig();
		PADDING = cfg.getPadding();
		SIZE = cfg.getWindowSize();
	}
	
	/**
	 * 数字图片  （260 * 36）
	 */
	private static final Image IMG_NUMBER = new ImageIcon("Graphics/string/num.png").getImage();
	/**
	 * 数字切片高度
	 */
	private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null);
	/**
	 * 数字切片宽度
	 */
	protected static final int IMG_NUMBER_W = IMG_NUMBER.getWidth(null)/10;
	/**
	 * 矩形值槽
	 */
	private static Image IMG_EXP = new ImageIcon("Graphics/windows/rect.png").getImage();
	
	/**
	 * 矩形值槽（高度）
	 */
	private static final int EXP_H = IMG_EXP.getHeight(null);
	/**
	 * 矩形值槽（宽度）
	 */
	private static final int EXP_W = IMG_EXP.getWidth(null); 
	
	
	/*
	 * 构造函数
	 */
	public Layer(int x,int y,int w,int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	/**
	 * 设置游戏数据
	 * @param dto
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	/**
	 * 绘制窗口方法
	 * @author yiweiyhangFT
	 * @param g  画笔
	 */
	protected  void createWindow(Graphics g){
		
		//g.drawImage(WINDOW_IMAGE, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		// 左上
				g.drawImage(WINDOW_IMAGE, x, y, (x + SIZE), (y + SIZE), 0, 0, SIZE, SIZE, null);
				// 中上
				g.drawImage(WINDOW_IMAGE, (x + SIZE), y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
				// 右上
				g.drawImage(WINDOW_IMAGE, (x + w - SIZE), y, (x + w), (y + SIZE), (WINDOW_W - SIZE), 0, WINDOW_W, SIZE, null);
				// 左中
				g.drawImage(WINDOW_IMAGE, x, (y + SIZE), (x + SIZE), (y + h - SIZE), 0, SIZE, SIZE, (WINDOW_H - SIZE), null);
				// 中央
				g.drawImage(WINDOW_IMAGE, (x + SIZE), (y + SIZE), (x + w - SIZE), (y + h - SIZE), SIZE, SIZE, (WINDOW_W - SIZE),
						(WINDOW_H - SIZE), null);
				// 右中
				g.drawImage(WINDOW_IMAGE, (x + w - SIZE), y + SIZE, (x + w), (y + h - SIZE), (WINDOW_W - SIZE), SIZE, WINDOW_W, WINDOW_H - SIZE,
						null);
				//左下
				g.drawImage(WINDOW_IMAGE, x,(y+h-SIZE), (x+SIZE), (y+h), 0, (WINDOW_H-SIZE), SIZE, WINDOW_H, null);
				//中下
				g.drawImage(WINDOW_IMAGE, (x+SIZE), (y+h-SIZE), (x+w-SIZE), (y+h), SIZE, (WINDOW_H-SIZE), (WINDOW_W-SIZE), WINDOW_H, null);
				//右下
				g.drawImage(WINDOW_IMAGE, (x+w-SIZE), (y+h-SIZE), (x+w), (y+h), (WINDOW_W-SIZE), (WINDOW_H-SIZE), WINDOW_W, WINDOW_H, null);
	}

	/**
	 * 刷新具体内容
	 * @author yiweiyihangFT
	 * @param g  画笔
	 */
	abstract public void paint(Graphics g);
	
	/**
	 * 绘制等级数字
	 * @param paddingL  左上角x间距
	 * @param paddingU  左上角y间距
	 * @param number    要显示的数字
	 * @param maxBit    最大位数
	 * @param g         画笔对象
	 */
	protected void drawNumberLeftPadding(int paddingL, int paddingU, int number,int maxBit,Graphics g){
		
		//把要打印的数字转换为字符串
		String strNum = Integer.toString(number);
		// 循环绘制数字右对齐
		for(int i = 0; i < maxBit; i++){
			// 判断是否满足绘制条件
			if(maxBit - i <= strNum.length()){
				// 计算数字在字符串中的下表
				int idx = i - maxBit + strNum.length();
				//把数字number中的每一位取出
				int singleNum = strNum.charAt(idx) - '0';
				g.drawImage(IMG_NUMBER, 
						this.x + paddingL + i * IMG_NUMBER_W, 
						this.y + paddingU,
						this.x  + paddingL + i * IMG_NUMBER_W + IMG_NUMBER_W, 
						this.y + paddingU + IMG_NUMBER_H,
						singleNum * IMG_NUMBER_W, 0, 
						(singleNum + 1) * IMG_NUMBER_W, IMG_NUMBER_H,
						null);
				
			}
		}
	}
	
	

	/**
	 * 绘制值槽
	 * @param g
	 */
	
	protected void drawRect(int x, int y,double value,double maxValue,Graphics g){
		// 初始化宽度
		int rect_x =  this.x + PADDING + 2;
		int rect_y = this.y + y + 2;
		
		// 绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x - 2,rect_y - 2, x, EXP_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x - 1, rect_y - 1 , x - 2, EXP_H + 2);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(rect_x ,rect_y , x - 4, EXP_H);
		// 求出比值
		double percent = value / maxValue;
		//求出宽度
		int w = (int)(percent * (x - 4));
		// 求出颜色
		int subIdx = (int)(percent * EXP_W);
		// 绘制值槽
		g.drawImage(IMG_EXP, 
				rect_x , rect_y,
				rect_x + w, rect_y + EXP_H,
				subIdx, 0,
				subIdx + 1, EXP_H, null);
		
	}
	
	/**
	 * 正中绘图
	 */
	protected void drawAtCenter(Image img,Graphics g){
		int ImgW = img.getWidth(null);
		int ImgH = img.getHeight(null);
		int ImgX = this.x + (this.w - ImgW >> 1);
		int ImgY = this.y + (this.h - ImgH >> 1);
		g.drawImage(img,ImgX , ImgY , null);
	}

}
