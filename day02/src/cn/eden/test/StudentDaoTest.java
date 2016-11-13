package cn.eden.test;

import org.junit.Test;

import cn.eden.dao.StudentDao;
import cn.eden.domain.Student;

public class StudentDaoTest {
	@Test
	public void testAdd() {
		Student s = new Student();
		s.setExamId(1);
		s.setGrade(100);
		s.setIdCard(1231231231);
		s.setLocation("湖南");
		s.setName("eden");
		StudentDao dao = new StudentDao();
		dao.add(s);
		
	}
}
