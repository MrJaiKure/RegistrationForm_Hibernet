package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/loginForm")
public class login extends HttpServlet {
		protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
			PrintWriter out=resp.getWriter();
			
			String myemail= req.getParameter("email1");
			String mypass=req.getParameter("Pass1");
			
			try {
//			making cnnection between my sql and jdbc usinG JDBC COMMANDS
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root", "#indianarmy123");
				PreparedStatement ps=con.prepareStatement("select* from register where email=? and password=?");
				
				ps.setString(1, myemail);
				ps.setString(2, mypass);
				
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					HttpSession session=req.getSession();
					session.setAttribute("session_name",rs.getString("name"));
//			request disaptcher is use to send request to the another page.
					RequestDispatcher rd=req.getRequestDispatcher("/user.jsp");
					rd.include(req, resp);
				}else {
					resp.setContentType("text/html");
					out.print("<h3 style='color:red'> Email id and password didn't match</h3>");
					RequestDispatcher rd= req.getRequestDispatcher("login.jsp");
					rd.include(req,resp);
					
				}
			}
			catch(Exception e) {
//				text/html is used to read the html tags by web server directly form servlet  file
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>" +e.getMessage()+"</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				e.printStackTrace();
			}
					
				
		}

	


}


