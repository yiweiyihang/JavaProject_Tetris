package main;

import control.GameControler;
import control.PlayerControler;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args) {
		//创建游戏数据源
		GameDto dto = new GameDto();
		//创建游戏面板
		JPanelGame panel = new JPanelGame(dto);
		
		//创建游戏逻辑块（安装游戏数据源）
		GameService service = new GameService(dto);
		//创建游戏控制器(连接游戏面板与游戏逻辑块)
		GameControler gameControler = new GameControler(panel, service);
		//创建玩家控制器（连接游戏控制器）
		PlayerControler playerControl = new PlayerControler(gameControler);
		//创建游戏窗口，安装游戏面板
		new JFrameGame(panel);
		//安装玩家控制器
		panel.setPlayerControl(playerControl);
	}

}
