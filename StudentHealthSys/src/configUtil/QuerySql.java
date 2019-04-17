package configUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class QuerySql {

	private String insertSQL="insert into stu_info(id,name,sex,age,hight,weight) values(?,?,?,?,?,?)";
	private String selectSQL="select * from stu_info";
    private Connection con=null;
       public QuerySql(){
    	   
       }
	@SuppressWarnings("finally")
	public List<StudentHealthJavaBean>  getAllStudent(){
		List<StudentHealthJavaBean> list=new ArrayList<StudentHealthJavaBean>();
		ResultSet rs=null;
		PreparedStatement ps=null;
		StudentHealthJavaBean student=null;
		     con=DataBaseConfig.getConnection();
		     try {
				ps=con.prepareStatement(selectSQL);
			     rs=ps.executeQuery();
			     while(rs.next()) {
			    	 student=new StudentHealthJavaBean();
			    	 student.setId(rs.getString("id"));
			    	 student.setName(rs.getString("name"));
			    	 student.setSex(rs.getString("sex"));
			    	 student.setAge(rs.getInt("age"));
			    	 student.setHight(rs.getFloat("hight"));
			    	 student.setWeight(rs.getFloat("weight"));
			    	 list.add(student);
			     }
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				DataBaseConfig.closeDatabaseConnection(con, ps, rs);
				if(list!=null)
					System.out.println("成功查询!");
				else {
					System.out.println("list是空值！");
				}
				return list;
			}
	}
	
	
	public int insertStudent(StudentHealthJavaBean student) {
		int num=0;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		    
		con=DataBaseConfig.getConnection();
		try {
			ps=con.prepareStatement("select * from stu_info where id=?");
			ps.setString(1, student.getId());
			rs=ps.executeQuery();
			if(rs.first()) {
			System.out.println("已经存在此学号的学生信息，不能插入了！");
			DataBaseConfig.closeDatabaseConnection(con, ps, rs);
			return 0;
			}
			ps=con.prepareStatement(insertSQL);
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setInt(4, student.getAge());
			ps.setFloat(5, student.getHight());
			ps.setFloat(6, student.getWeight());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			return num;
		}
		
	}
}
