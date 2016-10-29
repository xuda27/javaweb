package cn.eden.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 可变参数
 * 
 * @author Eden
 *
 */
public class Demo4 {

	@Test
	public void testSum() {
		sum(1, 2, 3, 4);

		// 这样也行
		int[] arr = { 1, 2, 3, 4 };
		sum(arr);
	}

	private void sum(int... nums) {
		// 可变参数可以把它看成数组
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.println(sum);
	}

	/**
	 * 需要注意的可变参数的问题 public void test(int ...nums, int x)不行
	 * 
	 * @param nums
	 * @param x
	 */
	public void test(int x, int... nums) {

	}

	/**
	 * 可变参数的注意细节 ：可变参数的数据类型（对象类型、基本类型）
	 */
	@Test
	public void test1() {
		List list = Arrays.asList(1, 2, 3);
		System.out.println(list);

		// 数组中的元素是对象
		Integer arr1[] = { 1, 2, 3 };
		list = Arrays.asList(arr1);
		System.out.println(list);

		// 把一整个基本类型数组当成对象
		int arr[] = { 1, 2, 3 };
		list = Arrays.asList(arr);
		System.out.println(list);
	}
}
