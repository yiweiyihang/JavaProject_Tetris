package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/**
	 * 窗口宽度
	 */
	private int width;
	/**
	 * 窗口高度
	 */
	private int height;
	/**
	 * 边框尺寸
	 */
	private int windowSize;
	/**
	 * 文字间距
	 */
	private int padding;
	/**
	 * 图层属性
	 */
	private List<LayerConfig> layersConfig;
	
	
	/**
	 * 构造函数
	 * 读取XML文件 获取全部游戏属性
	 * @throws DocumentException
	 */
	
	public GameConfig() throws DocumentException {
		//创建XML读取器
		SAXReader reader = new SAXReader();
		//读取XML文件
		Document doc = reader.read("config/cfg.xml");
		//获得XML文件的根节点
		Element game = doc.getRootElement();
		
		//配置窗口参数
		this.setFrameConfig(game.element("frame"));
		
		//配置系统参数
		this.setSystemConfig(game.element("system"));
		
		//配置数据访问参数
		this.setDataConfig(game.element("data"));
		
	}
	/**
	 * 配置窗口参数
	 * @param frame  配置文件中的窗口配置参数
	 */
	private void setFrameConfig(Element frame){
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));
		String str = frame.attributeValue("width");
		layersConfig = new ArrayList<LayerConfig>();
		List<Element> layers = frame.elements("layer");
		for(Element elm:layers){
			LayerConfig lc = new LayerConfig(elm.attributeValue("className"),
					Integer.parseInt(elm.attributeValue("x")),
					Integer.parseInt(elm.attributeValue("y")),
					Integer.parseInt(elm.attributeValue("w")),
					Integer.parseInt(elm.attributeValue("h"))
					);
			layersConfig.add(lc);
		}
	}
	
	
	/**
	 * 配置系统参数
	 * @param system  配置文件中的系统参数
	 */
	
	private void setSystemConfig(Element system){
		// TODO 
		
		
		
	}
	
	/**
	 * 配置数据访问参数
	 * @param data 配置文件中的数据访问参数
	 */
	
	private void setDataConfig(Element data){
		// TODO
		
		
	}
	
	
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getWindowSize() {
		return windowSize;
	}
	public int getPadding() {
		return padding;
	}
	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	
	
	
	
		
}
	
