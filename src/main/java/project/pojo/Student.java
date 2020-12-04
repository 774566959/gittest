package project.pojo;
import java.io.*;

/**
 * 学生pojo类
 * @author 陈泽彬
 * @version 1.2 2020-10-16
 */
public class Student implements Serializable {
	private int id;//学号
	private String name;//姓名
	private int sex;//性别，1为男，0为女
	private double score;//成绩	
	private String photo;//照片	
	
	//无参构造方法
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


	//重写toString方法，用以输出打印
	@Override
	public String toString() {
		//打印学生信息，根据性别的值返回男或女
		return "Students [学号=" + id + ", 姓名=" + name + ", 性别=" + sex + ",  成绩=" + score + ",照片=" + photo + "]";
	}
}
