package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Emp;
import com.project.dao.SqlQueries;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String opr = request.getParameter("opr");
		PrintWriter pw = response.getWriter();
		
		if(opr.equals("insert"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String mobile = request.getParameter("mobile");
			
			Emp ob = new Emp();
			ob.setId(id);
			ob.setName(name);
			ob.setCity(city);
			ob.setMobile(mobile);
			
			int status = SqlQueries.insert(ob);
			
			if(status != 0)
			{
				pw.print("<h1>Data inserted successfully...</h1>");
			}
			else
			{
				pw.print("<h1>Data not insserted...</h1>");
			}
		}
		else if(opr.equals("datafetch"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("datafetch.jsp");
			rd.forward(request, response);
			
		}
		else if(opr.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			int status=SqlQueries.Delete(id);
			if(status!=0)
			{
				pw.print("<h2>data deleted successfully</h2>");
				RequestDispatcher rd=request.getRequestDispatcher("datafetch");
				rd.include(request, response);
			}
			
		}
		else if(opr.equals("update"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
			rd.include(request, response);

		}
		else if(opr.equals("edit"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String mobile=request.getParameter("mobile");
			
			Emp ob=new Emp();
			
			ob.setId(id);
			ob.setName(name);
			ob.setCity(city);
			ob.setMobile(mobile);
			
			int status=SqlQueries.edit(ob);
			
			if(status!=0)
			{
				pw.print("<h2>data updated successfully</h2>");
				RequestDispatcher rd=request.getRequestDispatcher("datafetch");
				rd.include(request, response);
			}
			else
			{
				pw.print("<h2>data not updated successfully</h2>");

			}

		}
	}
}
