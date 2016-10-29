package cn.eden.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * 反射字段
 * @author Eden
 *
 */
public class Demo4 {
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.eden.reflect.Person");
		Field f = clazz.getField("name");
		// 获取字段的值
		String name = (String)f.get(p);
		System.out.println(name);
		// 获取字段的类型
		Class type = f.getType();
		System.out.println(type);
		
		//设置字段的值
		f.set(p, "xuda");
		System.out.println(p.name);
		
	}
}
