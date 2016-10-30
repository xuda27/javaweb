package cn.eden.generic;

import org.junit.Test;

/**
 * 自定义带泛型的方法
 * 
 * @author Eden
 *
 */
public class Demo3 {

	/**
	 * 自定义泛型方法
	 * <T> 声明类型
	 * 
	 * @param t
	 * @return
	 */
	public <T> T a(T t) {
		return t;
	}

	/**
	 * 声明三个泛型类型
	 * @param t
	 * @param e
	 * @param k
	 */
	public <T, E, K> void b (T t, E e, K k) {
		
	}
	
	@Test
	public void test() {
		System.out.println(a("aa"));
	}
}
