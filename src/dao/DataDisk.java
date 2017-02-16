package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataDisk implements Data{

	private static final String FILE_PATH = "save/recordDisk.dat";
	@Override
	public List<Player> loadData() {
		List<Player> players = null;
		ObjectInputStream ois = null;
		try {
			 ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			 players =(List<Player>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	@Override
	public void saveData(List<Player> players) {

		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(players);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		DataDisk dataDisk = new DataDisk();
		List<Player> players = new ArrayList<>();
//		players.add(new Player("小翼", 1024));
//		players.add(new Player("小白", 3200));
//		players.add(new Player("黎明", 4000));
//		players.add(new Player("FT", 10043));
//		players.add(new Player("美国队长", 29000));
//		dataDisk.saveData(players);
//		System.out.println("保存成功");
		
		
		players = dataDisk.loadData();
		for(Player p : players){
			System.out.println(p.getName() + ":" + p.getPoint());
		}
		
	}

}
