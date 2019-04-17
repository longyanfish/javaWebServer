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
		// TODO ������ִ��
		//super.doGet(req, resp);���ִ���˸��෽�����ܻ���Լ��ĸ���
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
			System.out.println("��������ʧ�ܡ�");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO ������ִ�����ִ���˸��෽�����ܻ���Լ��ĸ���
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
					System.out.println("û�гɹ���������!");
				    req.setAttribute("success", "û�ܳɹ���Ӵ�ѧ����Ϣ!");
				}
				else {
					System.out.println("�ɹ���������!");
				    req.setAttribute("success","�ɹ���Ӵ�ѧ����Ϣ!");
				    }
				RequestDispatcher dispatcher=req.getRequestDispatcher("/success.jsp");
				dispatcher.forward(req,resp);
				break;
			}
		}
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//�ڶ���ִ�У����˸���post����get�Զ�����doGet()����doPost()����
		super.service(arg0, arg1);
	}
	@Override
	public void init() throws ServletException {
		//��һ��ִ�У��Զ�����request\response�������service����
		super.init();
	}
}
