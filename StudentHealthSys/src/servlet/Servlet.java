package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import configUtil.QuerySql;
import configUtil.StudentHealthJavaBean;

 public class Servlet extends HttpServlet {
    public Servlet() {
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 第三步执行
		//super.doGet(req, resp);如果执行了父类方法可能会对自己的覆盖
		req.setCharacterEncoding("UTF-8");
		String methor=req.getParameter("methor");
		if(methor!=null) {
			QuerySql query=new QuerySql();
			switch(methor) {
			case "query_all":
				List<StudentHealthJavaBean> list=query.getAllStudent();
				req.setAttribute("list", list);
				RequestDispatcher rd=req.getRequestDispatcher("/query_all_student.jsp");
				rd.forward(req, resp);
				break;
			}
		}else {
			System.out.println("参数传输失败。");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 第三部执行如果执行了父类方法可能会对自己的覆盖
		//super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		String str=req.getParameter("methor");
		QuerySql q=new QuerySql();
		StudentHealthJavaBean student=new StudentHealthJavaBean();
		student.setId(req.getParameter("id"));
		student.setName(req.getParameter("name"));
		student.setSex(req.getParameter("sex"));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setHight(Float.parseFloat(req.getParameter("hight")));
		student.setWeight(Float.parseFloat(req.getParameter("weight")));
		if(str!=null&&student!=null) {
			switch(str) {
			case "insert":
				int n=q.insertStudent(student);
				if(n==0) {
					System.out.println("没有成功插入数据!");
				    req.setAttribute("success", "没能成功添加此学生信息!");
				}
				else {
					System.out.println("成功插入数据!");
				    req.setAttribute("success","成功添加此学生信息!");
				    }
				RequestDispatcher dispatcher=req.getRequestDispatcher("/success.jsp");
				dispatcher.forward(req,resp);
				break;
			}
		}
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//第二部执行，完了根据post还是get自动调用doGet()或者doPost()方法
		super.service(arg0, arg1);
	}
	@Override
	public void init() throws ServletException {
		//第一步执行，自动生成request\response对象调用service方法
		super.init();
	}
}
