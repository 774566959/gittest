package project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.dao.student.*;
import project.pojo.*;

/*import project.student.util.XmlTransformData;*/
import project.service.StudentService;
import project.dao.student.StudentMapper;
import project.pojo.PageIndexer;
import project.pojo.Student;

/**
 * 学生业务逻辑层实现类
 * @author 陈泽彬
 * @version 1.2 2020-10-16
 */
@Service("studentService")
@Transactional//没有这个有错误也会成功
public class StudentServiceImpl implements StudentService {
	
	//注解注入mapper
	@Autowired
	private StudentMapper studentmapper;
	
	/**
	 * 增加学生信息
	 * @param student 学生实体对象
	 * @return 返回添加状态，1成功，0失败，-1id重复
	 */
	@Override
	public int add(Student student) {
		int flag=-1;//id重复
		//判断学号是否重复
		if(studentmapper.getStudentById(student.getId()) == null){
			//调用数据访问层添加数据方法
			if(studentmapper.addStudent(student)==1){
				flag=1;//增加成功
			}else{
				flag=0;//增加失败，数据库添加异常
			}			
		}
		return flag;
	}

	/**
	 * 删除学生信息
	 * @param id 学号
	 * @return 返回删除状态，1成功，0失败，-1id不存在
	 */
	@Override
	public int delete(int id) {
		int flag=-1;//id不存在
		if(studentmapper.getStudentById(id) != null){
			if(studentmapper.deleteStudent(id)==1){
				flag=1;//删除成功
			}else{
				flag=0;//删除失败，数据库删除异常
			}			
		}
		return flag;
	}

	/**
	 * 修改学生信息
	 * @param student 学生实体对象
	 * @return 返回修改状态，1成功，0失败，-1id不存在
	 */
	@Override
	public int update(Student student) {
		int flag=-1;//id不存在
		if(studentmapper.getStudentById(student.getId()) != null){
			if(studentmapper.updateStudent(student)==1){
				flag=1;//修改成功
			}else{
				flag=0;//修改失败，数据库修改异常
			}			
		}
		return flag;
	}

	/**
	 * 根据学号查询学生信息
	 * @param id 学号
	 * @return 返回学生实体对象
	 */
	@Override
	public Student search(int id) {
		//如果有数据返回第一条数据，否则返回空
		if(studentmapper.getStudentById(id) != null){
			Student student = studentmapper.getStudentById(id);
			return student;}
		else{
			return null;}
	}

	@Override
	public List<Student> list(PageIndexer page) {
		List<Student> students = studentmapper.getStudentsByPage(page);
		return students;
	}

	@Override
	public List<Student> list() {
		List<Student> students = studentmapper.getAllStudents();
		return students;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteAndInsert(Student student) {
		studentmapper.deleteStudent(student.getId()-1);
		//int a=1/0;
		studentmapper.addStudent(student);
		return 1;

		// return studentMapper.deleteAndInsertStudent(student);
}

	
}
