package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@jakarta.servlet.annotation.WebServlet("/login")
public class LoginServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
Connection con;
public void init()
{
	try {
		ServletContext sc= getServletContext();
		String s1=sc.getInitParameter("driver");
		String s2=sc.getInitParameter("url");
		String s3=sc.getInitParameter("username");
		String s4=sc.getInitParameter("password");
		Class.forName(s1);
		con=DriverManager.getConnection(s2,s3,s4);
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
		 e.printStackTrace();
		
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {
		String s1=request.getParameter("uname");
		String s2=request.getParameter("pass");
		PreparedStatement pstmt=con.prepareStatement("select *from info where uname=? and pword=?");
		pstmt.setString(1,s1);
		pstmt.setString(2,s2);
		ResultSet
		rs=pstmt.executeQuery();
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=red text=yellow><h1>");
		if(rs.next())
		{
			pw.println("Log in Successfull... "+  s1);
			
		}
		else
		{
			pw.println("Invalid Username/Password");
			
		}pw.println("</h1></body></html>");
		

}catch(SQLException e)
	{
	e.printStackTrace();
	{
		e.printStackTrace();
	}
	}
	
	
	}

}
