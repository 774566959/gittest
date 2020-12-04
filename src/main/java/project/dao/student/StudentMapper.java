package project.dao.student;

import java.util.*;

import project.pojo.*;

/**
 * Student���ݷ��ʲ�ӿ�
 * @author �����
 * @version 1.0 2020-11-16
 */
public interface StudentMapper {
	
	
	/**
	 * ��ѯ��ȡ����ѧ����Ϣ
	 * @return ����ѧ��ʵ�巺�ͼ���
	 */
	List<Student> getAllStudents();
	
	/**
	 * ����ѧ�Ų�ѯ��ȡѧ����Ϣ
	 * @param id ѧ��
	 * @return ����ѧ��ʵ�����
	 */
	Student getStudentById(int id);
	
	/**
	 * ��ҳ��ʾѧ���б�
	 * @param page ��ҳʵ�����
	 * @return ����ѧ��ʵ�����ķ��ͼ���
	 */
	List<Student> getStudentsByPage(PageIndexer page);
	
	/**
	 * ����ѧ����¼����
	 * @return
	 */
	int getCount();
	
	/**
	 * ���ѧ��
	 * @param student ѧ��ʵ�����
	 * @return �����Ƿ���ӳɹ�
	 */
	int addStudent(Student student);
	
	/**
	 * �޸�ѧ��
	 * @param student ѧ��ʵ�����
	 * @return �����Ƿ��޸ĳɹ�
	 */
	int updateStudent(Student student);
	
	/**
	 * ɾ��ѧ��
	 * @param id ѧ��
	 * @return �����Ƿ�ɾ���ɹ�
	 */
	int deleteStudent(int id);
}
