package com.studentmemo;

import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.*;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logic")
public class LogicServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
//		System.out.println(1);
		PrintWriter out = res.getWriter();
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		String query = "select * from students";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url,username,password);
//			System.out.println(con);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				if(rs.getString(1).equals(req.getParameter("student_id")))
				{
					out.print("<html>");
					out.print("<head>");
					out.print("<style>*{margin : 0; padding : 0;}body{background-color : orange !important;}</style>");
					out.print("<link rel='stylesheet' href='https:\\maxcdn.bootstrapcdn.com\\bootstrap\\4.0.0\\css\\bootstrap.min.css' />");
					out.print("<title>Result Page</title>");		
					out.print("</head>");
					out.print("<body bgcolor = 'orange'>");
					out.print("<table class = 'table'");
					out.print("<tr>");
					out.print("<td> Name </td>");
					out.print("<td> roll number </td>");
					out.print("<td> marks </td>");
					out.print("<td> remark </td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<td>" + rs.getString(2) +"</td>");
					out.print("<td>" + rs.getString(1) +"</td>");
					out.print("<td>" + rs.getString(3) +"</td>");
					if(Integer.parseInt(rs.getString(3)) >= 70)
					{
						out.println("<td style = 'font-weight : bold;'> Distinction </td>");
					}
					else
					{
						out.print("<td></td>");
					}
					out.print("</tr>");
					out.print("</table>");
					out.print("<script src='https:\\maxcdn.bootstrapcdn.com\\bootstrap\\4.0.0\\js\\bootstrap.min.js'></script>");
					out.print("</body>");
					out.print("</html>");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
