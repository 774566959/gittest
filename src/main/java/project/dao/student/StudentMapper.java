package project.dao.student;

import java.util.*;

import project.pojo.*;

/**
 * Student数据访问层接口
 * @author 陈泽彬
 * @version 1.0 2020-11-16
 */
public interface StudentMapper {
	
	
	/**
	 * 查询获取所有学生信息
	 * @return 返回学生实体泛型集合
	 */
	List<Student> getAllStudents();
	
	/**
	 * 根据学号查询获取学生信息
	 * @param id 学号
	 * @return 返回学生实体对象
	 */
	Student getStudentById(int id);
	
	/**
	 * 分页显示学生列表
	 * @param page 分页实体对象
	 * @return 返回学生实体对象的泛型集合
	 */
	List<Student> getStudentsByPage(PageIndexer page);
	
	/**
	 * 计算学生记录总数
	 * @return
	 */
	int getCount();
	
	/**
	 * 添加学生
	 * @param student 学生实体对象
	 * @return 返回是否添加成功
	 */
	int addStudent(Student student);
	
	/**
	 * 修改学生
	 * @param student 学生实体对象
	 * @return 返回是否修改成功
	 */
	int updateStudent(Student student);
	
	/**
	 * 删除学生
	 * @param id 学号
	 * @return 返回是否删除成功
	 */
	int deleteStudent(int id);
}
