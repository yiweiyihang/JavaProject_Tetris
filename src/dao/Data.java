package dao;

import java.util.List;

import dto.Player;
/**
 * 数据持久层接口
 * @author 32618
 *
 */
public interface Data {
	

	/**
	 * 读取数据
	 */
	List<Player> loadData();
	
	/**
	 * 存储数据
	 */
	void saveData(List<Player> players);
}
