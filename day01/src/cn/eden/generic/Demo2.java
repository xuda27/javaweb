package cn.eden.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 泛型在集合中的使用
 * 
 * @author Eden
 *
 */
public class Demo2 {
	@Test
	public void test1() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");

		// 传统
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}

		// 增强for
		for (String l : list) {
			System.out.println(l);
		}
	}

	/**
	 * 泛型的类型必须是一个对象类型
	 */
	@Test
	public void test2() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");

		// keyset
		for (Integer key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}

		// entrySet
		for (Map.Entry<Integer, String> set : map.entrySet()) {
			System.out.println(set.getKey() + ":" + set.getValue());
		}
	}
}
