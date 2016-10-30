package cn.eden.beanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**
 * 使用beanUtils操纵bean属性
 * 
 * @author Eden
 *
 */
public class Demo1 {
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "xuda");
		System.out.println(p.getName());
	}

	/**
	 * 自动给你转换类型 支持8种基本类型
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "age", "22");
		System.out.println(p.getAge());
	}

	/**
	 * beanUtils框架只支持基本数据类型转换 手动转换类型 其他类型
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		ConvertUtils.register(new Converter() {

			@Override
			public Date convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				if (!(value instanceof String)) {
					throw new ConversionException("只支持String类型转换");
				}
				String str = (String) value;
				str = str.trim();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return (Date) sdf.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		BeanUtils.setProperty(p, "birthday", "1994-03-08");
		System.out.println(p.getBirthday().toLocaleString());
	}

	@Test
	public void test4() throws Exception {
		Person p = new Person();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(p, "birthday", "1994-03-08");
		System.out.println(p.getBirthday().toLocaleString());
	}

	/**
	 * 用map集合中的值，填充bean的属性
	 * 
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Map map = new HashMap<>();
		map.put("name", "xuda");
		map.put("password", "root");
		map.put("age", "22");
		map.put("birthday", "1994-03-08");

		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		Person p = new Person();
		BeanUtils.populate(p, map);
		System.out.println(p);
	}

}
