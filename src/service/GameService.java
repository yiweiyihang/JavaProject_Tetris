package service;

import dto.GameDto;

public class GameService {

	private GameDto dto = new GameDto();

	public GameService(GameDto gameDto) {
		super();
		this.dto = gameDto;
	}

	
	
	
	public void gameTest() {
		// TODO Auto-generated method stub
		int temp = dto.getNowPoint();
		dto.setNowPoint(temp+1);
		
	}
	
}
