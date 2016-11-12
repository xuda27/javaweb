package cn.eden.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * JAXP 开发包 
 * 利用dom完成文档的crud
 * 
 * @author Eden
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 得到dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		Demo1 d = new Demo1();
		// 递归遍历子节点
		d.listXML(document);
	}
	
	/**
	 * 列出子节点
	 * @param node
	 */
	public void listXML(Node node) {
		System.out.println(node.getNodeName());
		NodeList childNodes = node.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node child = childNodes.item(i);
			listXML(child);
		}
	}

}
