package cn.eden.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 利用dom读取xml
 * 
 * @author Eden
 *
 */
public class Demo2 {
	private Document document;

	@Before
	public void before() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 得到dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse("src/book.xml");
	}

	/**
	 * 读取标签值
	 */
	@Test
	public void test1() {
		NodeList elements = this.document.getElementsByTagName("书名");
		Node node = elements.item(0);
		System.out.println(node.getTextContent());
	}

	/**
	 * 读取标签中的属性值
	 */
	@Test
	public void test2() {
		NodeList elements = this.document.getElementsByTagName("作者");
		Node node = elements.item(0);
		// Node中的方法满足不了需求，可以把对象强制转换成Node中的子类
		Element e = (Element) node;
		String att = e.getAttribute("联系信息");
		System.out.println(att);
	}

	/**
	 * 向xml文档中添加售价节点
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Document document = this.document;
		// 创建要添加的节点
		Element price = document.createElement("售价");
		price.setTextContent("100元");
		// 把创建的节点放到书节点下
		Node book = document.getElementsByTagName("书").item(0);
		book.appendChild(price);
		
		//把内存中更新后的对象树,定回到xml文档中,序列化
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/book.xml")));
	}
}
