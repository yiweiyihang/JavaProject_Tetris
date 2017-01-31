package config;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import main.Main;

public class ConfigReader {
	
	public static void readConfig() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read("config/cfg.xml");
		Element game = doc.getRootElement();
		Element frame = game.element("frame");
		String str = frame.attributeValue("width");
		List<Element> layers = frame.elements("layer");
		for(Element elm:layers){
			System.out.print(elm.attributeValue("className")+",");
			System.out.print(elm.attributeValue("x")+",");
			System.out.print(elm.attributeValue("y")+",");
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) throws DocumentException {
		readConfig();
	}

}
