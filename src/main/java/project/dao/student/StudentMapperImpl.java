package project.dao.student;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import project.pojo.PageIndexer;
import project.pojo.Student;
@Repository
public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> students=this.getSqlSession().selectList("project.dao.student.StudentMapper.getAllStudents");
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Student student=this.getSqlSession().selectOne("project.dao.student.StudentMapper.getStudentById", id);
		return student;
	}

	@Override
	public List<Student> getStudentsByPage(PageIndexer page) {
		List<Student> students=this.getSqlSession().selectList("project.dao.student.StudentMapper.getStudentsByPage", page);
		return students;
	}

	@Override
	public int getCount() {
		int count=this.getSqlSession().selectOne("project.dao.student.StudentMapper.getCount");
		return count;
	}

	@Override
	public int addStudent(Student student) {
		System.out.println(student.getPhoto());
		int flag=this.getSqlSession().insert("project.dao.student.StudentMapper.addStudent",student);
		return flag;
	}

	@Override
	public int updateStudent(Student student) {
		int flag=this.getSqlSession().update("project.dao.student.StudentMapper.updateStudent",student);
		return flag;
	}

	@Override
	public int deleteStudent(int id) {
		int flag=this.getSqlSession().delete("project.dao.student.StudentMapper.deleteStudent",id);
		return flag;
	}

}
