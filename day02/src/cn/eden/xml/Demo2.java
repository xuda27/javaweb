package cn.eden.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class Demo2 {

	/**
	 * 得到dom解析器
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//得到dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		System.out.println(builder);
		
		Document document = builder.parse("src/book.xml");
	}

}
