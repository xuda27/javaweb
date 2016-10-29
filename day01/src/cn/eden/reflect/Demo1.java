package cn.eden.reflect;
/**
 * 反射：加载类，获得类的字节码
 * @author Eden
 *
 */
public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 加载Person类,得到Person字节码，封装为一个Class对象
		// 1.需要类的完整名称
		Class clazz = Class.forName("cn.eden.reflect.Person");
		// 2.
		Class clazz1 = new Person().getClass();
		// 3.
		Class clazz2 = Person.class;
	}
}
