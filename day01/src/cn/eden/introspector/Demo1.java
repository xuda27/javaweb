package cn.eden.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 使用内省API操作bean的属性
 * 
 * @author Eden
 *
 */
public class Demo1 {
	@Test
	public void test1() throws Exception {
		// 不获取从Object类继承的属性
		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);
		// 得到属性描述器
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}

	/**
	 * 操纵bean的指定属性：age
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// 得到属性的写方法，为属性赋值
		Method method = pd.getWriteMethod(); // setAge()
		method.invoke(p, 22);
		System.out.println(p.getAge());

		// 获取属性的值
		method = pd.getReadMethod(); // getAge()
		System.out.println(method.invoke(p, null));
	}

	/**
	 * 获得bean的指定属性age的类型
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
	}
}
