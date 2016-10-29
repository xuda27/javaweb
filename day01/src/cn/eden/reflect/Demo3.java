package cn.eden.reflect;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 反射（解剖）类的方法
 * @author Eden
 *
 */
public class Demo3 {

	/**
	 * 解剖方法：public void a() {...}
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Method method = clazz.getMethod("a", null);
		method.invoke(p, null);
	}
	
	/**
	 * 解剖方法：public void a(String name, String password){...}
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Method method = clazz.getMethod("a", String.class, String.class);
		method.invoke(p, "Eden", "pwd");
	}
	
	/**
	 * 解剖方法：public Class[] a(String name, String[] password) {...}
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Method method = clazz.getMethod("a", String.class, String[].class);
		Class[] ss = (Class[]) method.invoke(p, "Eden", new String[]{"1"});
		System.out.println(ss[0]);
	}
	
	/**
	 * 解剖方法：private void a(InputStream in) {...}
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Method method = clazz.getDeclaredMethod("a", InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new ByteArrayInputStream(new byte[1024]));
	}
	
	/**
	 * 解剖方法：public static void a(int num) {...}
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Method method = clazz.getDeclaredMethod("a", int.class);
		method.invoke(null, 1);
	}
}
