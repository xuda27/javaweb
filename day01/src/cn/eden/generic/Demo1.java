package cn.eden.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 
 * @author Eden
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		// 报错
		// List list = new ArrayList();
		// list.add("a");
		// Integer i = (Integer)list.get(0);

		// 避免强制类型转换
		// 把原来程序运行时可能发生问题，转变为编译时的问题，以此提高程序的可读性和稳定性
		List<String> list = new ArrayList<String>();
		list.add("a");
		String str = list.get(0);
	}
}
