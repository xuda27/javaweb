package cn.eden.generic;

/**
 * 1.编写一个泛型方法，实现指定位置上的数组元素的交换 
 * 2.编写一个泛型方法，接受一个任意数组，并颠倒数组中的所有元素
 * 
 * @author Eden
 *
 */
public class Demo5 {

	/**
	 * 1.编写一个泛型方法，实现指定位置上的数组元素的交换
	 * 
	 * @param arr
	 *            数组
	 * @param pos1
	 *            第一个位置
	 * @param pos2
	 *            第二个位置
	 */
	public <T> void swap(T arr[], int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	/**
	 * 2.编写一个泛型方法，接受一个任意数组，并颠倒数组中的所有元素
	 * 
	 * @param arr
	 *            目标数组
	 */
	public <T> void reverse(T arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (true) {
			if (start >= end) {
				break;
			}
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
