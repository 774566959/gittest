package project.pojo;
import java.io.*;

/**
 * ѧ��pojo��
 * @author �����
 * @version 1.2 2020-10-16
 */
public class Student implements Serializable {
	private int id;//ѧ��
	private String name;//����
	private int sex;//�Ա�1Ϊ�У�0ΪŮ
	private double score;//�ɼ�	
	private String photo;//��Ƭ	
	
	//�޲ι��췽��
	public Student(){		
	}
	
	
	public Student(int id,String name,int sex,double score){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.score=score;
	}
	

	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	//��дtoString���������������ӡ
	@Override
	public String toString() {
		//��ӡѧ����Ϣ�������Ա��ֵ�����л�Ů
		return "Students [ѧ��=" + id + ", ����=" + name + ", �Ա�=" + sex + ",  �ɼ�=" + score + ",��Ƭ=" + photo + "]";
	}
}
