package cn.eden.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo3 {

	/**
	 * ����dom����ĵ���crud
	 * @param args
	 * @throws Exception 
	 * @throws ParserConfigurationException 
	 * @throws Exception 
	 * @throws SAXException 
	 * @throws Exception 
	 */
	private Document document;
	@Before
	public void before() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse("src/book.xml");
	}
	
	//����
	@Test
	public void listXml() throws ParserConfigurationException, SAXException, Exception{
		list(document);
	}
	
	public void list(Node node){
		System.out.println(node.getNodeName());
		NodeList list = node.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node child = list.item(i);
			list(child);
		}
	}
	
	//��ȡ�����ڵ��ֵ��<����>javaweb����</����>
	@Test
	public void test1(){
		Document document = this.document;
		Node node = document.getElementsByTagName("����").item(0);
		String value = node.getTextContent();
		System.out.println(value);
	}
	
	//��ȡ�������Ե�ֵ��<�ۼ� type="rmb">39.00Ԫ</�ۼ�> 
	@Test
	public void test2(){
		Document document = this.document;
		Node node = document.getElementsByTagName("�ۼ�").item(0);
		Element price =  (Element) node;   //����node���㲻�ˣ���nodeǿת����Ӧ����
		String attValue = price.getAttribute("type");
		System.out.println(attValue);
	}
	
	//��xml�ĵ�������ۼ۽ڵ�
	@Test
	public void test3() throws Exception{
		Document document = this.document;
		//����Ҫ�ҵĽڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59Ԫ");
		//�Ѵ����Ľ��ҵ���ڵ���
		Node book = document.getElementsByTagName("��").item(0);
		book.appendChild(price);
		
		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	
	//��xml�ĵ���ָ��λ��������ۼ۽ڵ�
	@Test
	public void test4() throws Exception{
		Document document = this.document;
		
		//����Ҫ��ӵĽڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59Ԫ");
		
		//�õ�Ҫ���ĸ��ڵ��Ϲ��ӽڵ�
		Node book = document.getElementsByTagName("��").item(0);
		
		//��ο��ڵ�ǰ�����½ڵ�
		book.insertBefore(price, document.getElementsByTagName("�ۼ�").item(0));
		
		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
		
	}
	
	//��xml�ĵ���ӽڵ�����
	@Test
	public void test5() throws Exception{
		Document document = this.document;
		
		//�õ�Ҫ������ԵĽڵ�
		Element author = (Element) document.getElementsByTagName("����").item(0);
		author.setAttribute("id", "12");  //��ڵ������
		
		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
		
	}
	
	
	//ɾ��xml�ĵ��е��ۼ۽ڵ�
	@Test
	public void test6() throws Exception{
		
		Document document = this.document;
		
		//�õ�Ҫɾ���Ľڵ�
		Node price = document.getElementsByTagName("�ۼ�").item(0);
		
		//�õ�Ҫɾ���Ľڵ�ĸ���
		Node parent = document.getElementsByTagName("��").item(0);
		
		parent.removeChild(price);
		

		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	//ɾ��2   : ɾ���ۼ۽ڵ����ڵ�����
	@Test
	public void test7() throws Exception{
		
		Document document = this.document;
		
		//�õ�Ҫɾ���Ľڵ�
		Node price = document.getElementsByTagName("�ۼ�").item(0);
		price.getParentNode().getParentNode().removeChild(price.getParentNode());
		

		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	
	@Test
	public void test8() throws Exception{
		Document document = this.document;
		document.getElementsByTagName("�ۼ�").item(1).setTextContent("19Ԫ");
		//���ڴ��и��º�����������¶��ص�xml�ĵ���
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer tf = factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	
	
	
	
	

}
