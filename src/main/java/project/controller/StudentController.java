package project.controller;




import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.pojo.PageIndexer;
import project.pojo.Student;
import project.service.StudentService;
/**
 * Student���Ʋ�
 * @author �����
 * @version 1.0 2020-11-25
 */
@Controller
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	//���ѧ��
	@RequestMapping(value = "/addstu")
	public String addstu(Student student,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file ,HttpSession session, Model model) {
		String photo = handleFile(file,request);
		student.setPhoto(photo);
		int flag = studentservice.add(student);
		if(flag==1){
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('��ӳɹ�')</script>");
			return "forward:/pagelist";
		}else if(flag==-1) {
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('ѧ���ظ�')</script>");
			return "addstudent";
		}else{
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('���ݿ����')</script>");
			return "addstudent";
		}
	}
	
	//��ѧ�Ų�ѯѧ��
	@RequestMapping(value = "/getstu")
	public String selstu(int id,HttpServletRequest request,HttpSession session, Model model) {
		Student student = studentservice.search(id);
		String url = request.getHeader("referer");
		url = request.getHeader("referer").substring(url.lastIndexOf("/")+1);
		request.setAttribute("student", student);
		System.out.println("��ַ�ǣ�"+url);
		if(url.equals("selstudent.jsp"))
			return "selstudent";
		else if(url.indexOf("pagelist")>=0)
			return "updatestudent";
		else
			return "selstudent";
	}
	
	//��ҳ�鿴ѧ����Ϣ
	@RequestMapping(value = "/pagelist")
	public String pagelist(HttpServletRequest request,HttpSession session, Model model) {
		PageIndexer pi = new PageIndexer(1, 3, 0);
		if (request.getParameter("pageIndex") != null) {
			pi.setPageIndex(Integer.parseInt(request
							.getParameter("pageIndex")));
		}
		List<Student> lists = studentservice.list(pi);
		pi.setPageCount((int) (Math.ceil(studentservice.list().size() * 1.0
				/ pi.getPageSize())));
		request.setAttribute("students", lists);
		request.setAttribute("pi", pi);
		return "liststudentbypage";
	}
	
	//ɾ��ѧ����Ϣ
	@RequestMapping(value = "/delstu")
	public String delstu(int id,HttpServletRequest request,HttpSession session, Model model) {
		int flag=studentservice.delete(id);
		if(flag==1){
			model.addAttribute("delmsg",
					"<script language='JavaScript'>alert('ɾ���ɹ�')</script>");
			return "forward:/pagelist";
		}else{
			model.addAttribute("delmsg",
					"<script language='JavaScript'>alert('ɾ��ʧ��')</script>");
			return "updatestudent";
		}
	}
	
	
	
	//�޸�ѧ����Ϣ
	@RequestMapping(value = "/updstu")
	public String updstu(Student student,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file ,HttpSession session, Model model) {
		String photo = handleFile(file,request);
		student.setPhoto(photo);
		int flag=studentservice.update(student);
		if(flag==1){
			model.addAttribute("updatemsg",
					"<script language='JavaScript'>alert('�޸ĳɹ�')</script>");
			return "forward:/pagelist";
		}else{
			model.addAttribute("updatemsg",
					"<script language='JavaScript'>alert('�޸�ʧ��')</script>");
			return "forward:/pagelist";
		}
	}
	
	public String handleFile(MultipartFile uploadfile,HttpServletRequest request){
		// �ж����ϴ��ļ��Ƿ����
		if (!uploadfile.isEmpty()) {
			// ��ȡ�ϴ��ļ���ԭʼ����
			String originalFilename = uploadfile.getOriginalFilename();
			// �����ϴ��ļ��ı����ַĿ¼
			String dirPath = 
                   request.getServletContext().getRealPath("/files/");
			System.out.println("dirpath�ǣ�"+dirPath);
			File filePath = new File(dirPath);
			// ��������ļ��ĵ�ַ�����ڣ����ȴ���Ŀ¼
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			// ʹ��UUID���������ϴ����ļ�����(uuid_ԭʼ�ļ�����)
			String newFilename = UUID.randomUUID() + 
                                               "_"+originalFilename;
			try {
				// ʹ��MultipartFile�ӿڵķ�������ļ��ϴ���ָ��λ��
				dirPath+="/";
				uploadfile.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				//ʧ��
				e.printStackTrace();
                      return "error";
			}
			// �ɹ���������
			return "files/"+newFilename;
		}else{
			//ʧ��
			return "error";
		}
	
	}
}
