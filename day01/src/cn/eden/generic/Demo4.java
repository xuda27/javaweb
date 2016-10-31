package cn.eden.generic;

/**
 * 自定义泛型 作用在class上
 * 
 * @author Eden
 *
 */
public class Demo4<T, E> {

	/**
	 * 可以使用在普通方法上
	 * 
	 * @param t
	 * @param e
	 * @return
	 */
	public T a(T t, E e) {
		return null;
	}

	/**
	 * 自定义在class上的泛型不能使用在static方法中
	 * 
	 * @param t
	 */
	public static <T> void b(T t) {

	}
}
