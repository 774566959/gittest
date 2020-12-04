package project.service;

import java.util.List;



import project.pojo.Student;
import project.pojo.PageIndexer;

/**
 * 学生业务逻辑层接口
 * @author 陈泽彬
 * @version 1.2 2020-10-16
 */
public interface StudentService {
	/**
	 * 添加学生：进行业务逻辑判断，id号不能重复
	 * @param student 学生实体对象
	 * @return 返回是否添加成功的状态，1成功，0失败，-1id重复
	 */
	int add(Student student);
	
	/**
	 * 删除学生：进行业务逻辑判断，是否找到学生并是否删除
	 * @param id 学号
	 * @return 返回是否删除成功的状态，1成功，0失败，-1id不存在
	 */
	int delete(int id);
	
	/**
	 * 修改学生：进行业务逻辑判断，是否找到学生并是否修改
	 * @param student 学生实体对象
	 * @return 返回是否添加成功的状态，1成功，0失败，-1id不存在
	 */
	int update(Student student);
	
	/**
	 * 根据学号查询学生信息
	 * @param id 学号
	 * @return 返回学生实体对象
	 */
	Student search(int id);
	
	/**
	 * 查询所有学生信息
	 * @return 返回学生实体对象集合
	 */
	List<Student> list();
	
	/**
	 * 分页显示学生信息
	 * @param page 分页实体对象
	 * @return 返回指定页码的学生数据
	 */
	List<Student> list(PageIndexer page);
	//测试事务
	public int deleteAndInsert(Student student);
}
