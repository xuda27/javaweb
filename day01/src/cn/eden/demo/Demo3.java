package cn.eden.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 增强for
 * 
 * @author Eden
 *
 */
public class Demo3 {

	@Test
	public void test1() {
		int[] arr = { 1, 2, 3 };
		for (int num : arr) {
			System.out.println(num);
		}
	}

	@Test
	public void test2() {
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		for (Object obj : list) {
			int i = (int) obj;
			System.out.println(i);
		}
	}

	@Test
	public void test3() {
		// 无序
		// Map map = new HashMap<>();
		// 有序
		Map map = new LinkedHashMap<>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		// 传统方式1
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			int key = (int) it.next();
			String value = (String) map.get(key);
			System.out.println(key + "-" + value);
		}
	}

	@Test
	public void test4() {
		// 无序
		// Map map = new HashMap<>();
		// 有序
		Map map = new LinkedHashMap<>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		// 传统方式2
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			int key = (int) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + "-" + value);
		}
	}

	@Test
	public void test5() {
		// 无序
		// Map map = new HashMap<>();
		// 有序
		Map map = new LinkedHashMap<>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		// 增强for取map的第1种方式
		Set set = map.keySet();
		for (Object obj : map.keySet()) {
			int key = (int) obj;
			String value = (String) map.get(key);
			System.out.println(key + "-" + value);
		}
	}

	@Test
	public void test6() {
		// 无序
		// Map map = new HashMap<>();
		// 有序
		Map map = new LinkedHashMap<>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		// 增强for取map的第2种方式
		Set set = map.entrySet();
		for (Object obj : map.entrySet()) {
			Map.Entry entry = (Entry) obj;
			int key = (int) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + "-" + value);
		}
	}

	/**
	 * 使用增强for需要注意的几个问题 1.增强for只适合取数据，不能改变值更新值 2.如果要改变值，只能使用传统方式
	 */
	@Test
	public void test7() {
		int[] arr = { 1, 2, 3 };
		for (int i : arr) {
			i = 10;
		}
		System.out.println(arr[0]);

		for (int i = 0; i < arr.length; i++) {
			arr[0] = 4;
		}
		System.out.println(arr[0]);
	}
}
