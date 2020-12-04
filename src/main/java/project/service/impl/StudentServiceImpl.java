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
 * ѧ��ҵ���߼���ʵ����
 * @author �����
 * @version 1.2 2020-10-16
 */
@Service("studentService")
@Transactional//û������д���Ҳ��ɹ�
public class StudentServiceImpl implements StudentService {
	
	//ע��ע��mapper
	@Autowired
	private StudentMapper studentmapper;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ѧ��ʵ�����
	 * @return �������״̬��1�ɹ���0ʧ�ܣ�-1id�ظ�
	 */
	@Override
	public int add(Student student) {
		int flag=-1;//id�ظ�
		//�ж�ѧ���Ƿ��ظ�
		if(studentmapper.getStudentById(student.getId()) == null){
			//�������ݷ��ʲ�������ݷ���
			if(studentmapper.addStudent(student)==1){
				flag=1;//���ӳɹ�
			}else{
				flag=0;//����ʧ�ܣ����ݿ�����쳣
			}			
		}
		return flag;
	}

	/**
	 * ɾ��ѧ����Ϣ
	 * @param id ѧ��
	 * @return ����ɾ��״̬��1�ɹ���0ʧ�ܣ�-1id������
	 */
	@Override
	public int delete(int id) {
		int flag=-1;//id������
		if(studentmapper.getStudentById(id) != null){
			if(studentmapper.deleteStudent(id)==1){
				flag=1;//ɾ���ɹ�
			}else{
				flag=0;//ɾ��ʧ�ܣ����ݿ�ɾ���쳣
			}			
		}
		return flag;
	}

	/**
	 * �޸�ѧ����Ϣ
	 * @param student ѧ��ʵ�����
	 * @return �����޸�״̬��1�ɹ���0ʧ�ܣ�-1id������
	 */
	@Override
	public int update(Student student) {
		int flag=-1;//id������
		if(studentmapper.getStudentById(student.getId()) != null){
			if(studentmapper.updateStudent(student)==1){
				flag=1;//�޸ĳɹ�
			}else{
				flag=0;//�޸�ʧ�ܣ����ݿ��޸��쳣
			}			
		}
		return flag;
	}

	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ
	 * @param id ѧ��
	 * @return ����ѧ��ʵ�����
	 */
	@Override
	public Student search(int id) {
		//��������ݷ��ص�һ�����ݣ����򷵻ؿ�
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
