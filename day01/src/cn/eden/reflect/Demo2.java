package cn.eden.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 反射作用一：解剖Person类的构造方法，创建类的对象
 * 
 * @author Eden
 *
 */
public class Demo2 {

	/**
	 * 反射构造方法 public Person(){...}
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Class<?> clazz = Class.forName("cn.eden.reflect.Person");
		Constructor<?> c = clazz.getConstructor();
		Person p = (Person) c.newInstance(null);
	}

	/**
	 * 反射构造方法 public Person(String arg){...}
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Class<?> clazz = Class.forName("cn.eden.reflect.Person");
		Constructor<?> c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("");
	}

	/**
	 * 反射构造方法 public Person(String arg, String arg1){...}
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Class<?> clazz = Class.forName("cn.eden.reflect.Person");
		Constructor<?> c = clazz.getConstructor(String.class, String.class);
		Person p = (Person) c.newInstance("", "");
	}

	/**
	 * 反射私有构造方法 private Person(List list){...}
	 * 
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Class<?> clazz = Class.forName("cn.eden.reflect.Person");
		Constructor<?> c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);// 暴力反射
		// 私有不能被外面访问
		Person p = (Person) c.newInstance(new ArrayList<>());
	}

	/**
	 * class的newInstance()创建对象 跟test1一样 其实就是无参数的构造方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Class<?> clazz = Class.forName("cn.eden.reflect.Person");
		Person p = (Person) clazz.newInstance();
	}
}
