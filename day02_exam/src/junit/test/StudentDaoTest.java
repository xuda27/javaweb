package junit.test;

import org.junit.Test;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoTest {

	@Test
	public void testAdd(){
		
		Student s = new Student();
		s.setExamid("12121");
		s.setGrade(90);
		s.setIdcard("344545");
		s.setLocation("±±¾©");
		s.setName("aa");
		
		StudentDao dao = new StudentDao();
		dao.add(s);
		
	}
	
}
