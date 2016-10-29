package cn.eden.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 拆箱装箱
 * @author Eden
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		Integer i = 1; //装箱  JDK1.5以上
		int j = i; //拆箱 将对象赋值给基本类型
		
		//典型应用 add的是对象 自动装箱
		List list = new ArrayList();
		list.add(1);
		list.add(new Integer(2));
		list.add(3);
		list.add(4);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			int k = (Integer) it.next(); //拆箱
		}
	}

}
