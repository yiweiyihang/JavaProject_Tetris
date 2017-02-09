package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<>();
		players.add(new Player("FT", 100));
		players.add(new Player("FTT", 1000));
		players.add(new Player("FTTT", 2000));
		players.add(new Player("FTTTT", 3000));
		players.add(new Player("FTTTTTAs", 10043));
		players.add(new Player("FT", 100));
		players.add(new Player("FT", 100));
		players.add(new Player("FT", 100));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}

}
