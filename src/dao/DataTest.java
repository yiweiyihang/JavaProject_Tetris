package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<>();
		players.add(new Player("FT", 100));
		players.add(new Player("FTTTT", 3200));
		players.add(new Player("FTT", 4000));
//		players.add(new Player("FTTTTTAs", 10043));
//		players.add(new Player("FTTT", 2000));
		
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}

}
