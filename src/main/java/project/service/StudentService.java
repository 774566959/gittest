package project.service;

import java.util.List;



import project.pojo.Student;
import project.pojo.PageIndexer;

/**
 * ѧ��ҵ���߼���ӿ�
 * @author �����
 * @version 1.2 2020-10-16
 */
public interface StudentService {
	/**
	 * ���ѧ��������ҵ���߼��жϣ�id�Ų����ظ�
	 * @param student ѧ��ʵ�����
	 * @return �����Ƿ���ӳɹ���״̬��1�ɹ���0ʧ�ܣ�-1id�ظ�
	 */
	int add(Student student);
	
	/**
	 * ɾ��ѧ��������ҵ���߼��жϣ��Ƿ��ҵ�ѧ�����Ƿ�ɾ��
	 * @param id ѧ��
	 * @return �����Ƿ�ɾ���ɹ���״̬��1�ɹ���0ʧ�ܣ�-1id������
	 */
	int delete(int id);
	
	/**
	 * �޸�ѧ��������ҵ���߼��жϣ��Ƿ��ҵ�ѧ�����Ƿ��޸�
	 * @param student ѧ��ʵ�����
	 * @return �����Ƿ���ӳɹ���״̬��1�ɹ���0ʧ�ܣ�-1id������
	 */
	int update(Student student);
	
	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ
	 * @param id ѧ��
	 * @return ����ѧ��ʵ�����
	 */
	Student search(int id);
	
	/**
	 * ��ѯ����ѧ����Ϣ
	 * @return ����ѧ��ʵ����󼯺�
	 */
	List<Student> list();
	
	/**
	 * ��ҳ��ʾѧ����Ϣ
	 * @param page ��ҳʵ�����
	 * @return ����ָ��ҳ���ѧ������
	 */
	List<Student> list(PageIndexer page);
	//��������
	public int deleteAndInsert(Student student);
}
