package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControler;
import control.PlayerControler;
import dto.GameDto;
import service.GameService;

public class JPanelGame extends JPanel {

	private List<Layer> layers = null;
	/**
	 * 游戏数据源
	 */
	private GameDto dto = null;

	public JPanelGame(GameDto dto) {
		//获得游戏数据源
		this.dto = dto;
		//初始化组件
		initComponent();
		//初始化层
		initLayer();

	}

	/**
	 * 安装玩家控制器
	 * @param playerCtl  玩家控制器
	 */
	public void setPlayerControl(PlayerControler playerCtl){
		this.addKeyListener(playerCtl); 
	}
	@Override
	public void paintComponent(Graphics g) {
		//调用基类方法
		super.paintComponent(g);
		// 循环刷新游戏画面
		for (Layer lay : layers) {
			// 刷新层窗口
			lay.paint(g);
		}
		
		//返回焦点
		this.requestFocus();
		//或者写为 for(int i = 0;i < layers.size();layers.get(i++).paint(g)); 适用于循环体只有一句的情况
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		 
	}
	
	
	/**
	 * 初始化层
	 */
	private void initLayer(){
		try {
			// 获得游戏配置
			GameConfig cfg = ConfigFactory.getGameConfig();
			// 获得层配置
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// 创建游戏层数组
			layers = new ArrayList<Layer>(layersCfg.size());
			// 循环创建层对象
			for (LayerConfig layerCfg : layersCfg) {
				// 利用反射 通过一个字符串创建一个对象

				// 获得类对象
				Class<?> c = Class.forName(layerCfg.getClassName());
				// 获得构造函数
				Constructor ctr = c.getConstructor(int.class, int.class, int.class, int.class);
				// 利用构造函数创建实例
				Layer l = (Layer) ctr.newInstance(layerCfg.getX(), layerCfg.getY(), layerCfg.getW(), layerCfg.getH());
				//设置游戏数据对象
				l.setDto(dto);
				layers.add(l);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// // TODO 硬编码 不推荐
		// layers = new Layer[]{
		// new LayerBackGround(0, 0, 0, 0),
		// new LayerDataBase(40,32,334,279),
		// new LayerDisk(40,343,334,279),
		// new LayerGame(414,32,334,590),
		// new LayerButton(788,32,334,124),
		// new LayerNext(788,188,176,148),
		// new LayerLevel(964,188,158,148),
		// new LayerPoint(788,368,334,200)
		//
		// };
	}
}
