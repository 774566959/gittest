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
 * Student控制层
 * @author 陈泽彬
 * @version 1.0 2020-11-25
 */
@Controller
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	//添加学生
	@RequestMapping(value = "/addstu")
	public String addstu(Student student,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file ,HttpSession session, Model model) {
		String photo = handleFile(file,request);
		student.setPhoto(photo);
		int flag = studentservice.add(student);
		if(flag==1){
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('添加成功')</script>");
			return "forward:/pagelist";
		}else if(flag==-1) {
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('学号重复')</script>");
			return "addstudent";
		}else{
			model.addAttribute("addmsg",
					"<script language='JavaScript'>alert('数据库错误')</script>");
			return "addstudent";
		}
	}
	
	//按学号查询学生
	@RequestMapping(value = "/getstu")
	public String selstu(int id,HttpServletRequest request,HttpSession session, Model model) {
		Student student = studentservice.search(id);
		String url = request.getHeader("referer");
		url = request.getHeader("referer").substring(url.lastIndexOf("/")+1);
		request.setAttribute("student", student);
		System.out.println("地址是："+url);
		if(url.equals("selstudent.jsp"))
			return "selstudent";
		else if(url.indexOf("pagelist")>=0)
			return "updatestudent";
		else
			return "selstudent";
	}
	
	//分页查看学生信息
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
	
	//删除学生信息
	@RequestMapping(value = "/delstu")
	public String delstu(int id,HttpServletRequest request,HttpSession session, Model model) {
		int flag=studentservice.delete(id);
		if(flag==1){
			model.addAttribute("delmsg",
					"<script language='JavaScript'>alert('删除成功')</script>");
			return "forward:/pagelist";
		}else{
			model.addAttribute("delmsg",
					"<script language='JavaScript'>alert('删除失败')</script>");
			return "updatestudent";
		}
	}
	
	
	
	//修改学生信息
	@RequestMapping(value = "/updstu")
	public String updstu(Student student,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file ,HttpSession session, Model model) {
		String photo = handleFile(file,request);
		student.setPhoto(photo);
		int flag=studentservice.update(student);
		if(flag==1){
			model.addAttribute("updatemsg",
					"<script language='JavaScript'>alert('修改成功')</script>");
			return "forward:/pagelist";
		}else{
			model.addAttribute("updatemsg",
					"<script language='JavaScript'>alert('修改失败')</script>");
			return "forward:/pagelist";
		}
	}
	
	public String handleFile(MultipartFile uploadfile,HttpServletRequest request){
		// 判断所上传文件是否存在
		if (!uploadfile.isEmpty()) {
			// 获取上传文件的原始名称
			String originalFilename = uploadfile.getOriginalFilename();
			// 设置上传文件的保存地址目录
			String dirPath = 
                   request.getServletContext().getRealPath("/files/");
			System.out.println("dirpath是："+dirPath);
			File filePath = new File(dirPath);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			// 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
			String newFilename = UUID.randomUUID() + 
                                               "_"+originalFilename;
			try {
				// 使用MultipartFile接口的方法完成文件上传到指定位置
				dirPath+="/";
				uploadfile.transferTo(new File(dirPath + newFilename));
			} catch (Exception e) {
				//失败
				e.printStackTrace();
                      return "error";
			}
			// 成功返回数据
			return "files/"+newFilename;
		}else{
			//失败
			return "error";
		}
	
	}
}
